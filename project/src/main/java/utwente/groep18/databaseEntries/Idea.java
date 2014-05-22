package query.databaseEntries;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.joda.time.chrono.LimitChronology;

import com.myproject.domain.*;
import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLExpressions;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;

/**
 * A general Idea for the ThinkTank.<br>
 * This idea could be extended with more information
 * to create a {@link ConcreteIdea}.
 * 
 * @author Rob van Emous
 */
public class Idea extends Node {
	
	private boolean archived;
	private String description;
	private Votes votes;
	private Image image;
	private ArrayList<FieldOfStudy> fieldsOfStudy;
		
	/**
	 * Create a non-archived new idea.
	 * 
	 * @param node the node associated with this idea
	 * @param fieldsOfStudy the fields of study associated with this idea
	 * @param description the description of the idea
	 * @param image the image belonging to this idea
	 * @param votes the {@link Votes} belonging to this idea.
	 */
	public Idea(Node node, ArrayList<FieldOfStudy> fieldsOfStudy, String description, Image image, Votes votes) {
		super(node);
		this.archived = false;
		this.fieldsOfStudy = fieldsOfStudy;
		this.description = description;
		this.image = image;
		this.votes = votes;
	}
	
	/**
	 * Create a new idea.
	 * 
	 * @param node the node associated with this idea
	 * @param archived whether this idea is archived or not
	 * @param fieldsOfStudy the fields of study associated with this idea
	 * @param description the description of the idea
	 * @param image the image belonging to this idea
	 * @param votes the {@link Votes} belonging to this idea.
	 */
	public Idea(Node node, boolean archived, ArrayList<FieldOfStudy> fieldsOfStudy, String description, Image image, Votes votes) {
		super(node);
		this.archived = archived;
		this.fieldsOfStudy = fieldsOfStudy;
		this.description = description;
		this.image = image;
		this.votes = votes;
	}
	
	/**
	 * Creates a new idea which is a copy of the provided idea.
	 * 
	 * @param idea to be copied
	 */
	public Idea(Idea idea) {
		super(idea);
		this.archived = idea.isArchived();
		this.fieldsOfStudy = new ArrayList<FieldOfStudy>(idea.getFieldsOfStudy());
		this.description = new String(idea.getDescription());
		this.image = idea.image;
		this.votes = new Votes(idea.getVotes());
	}
	
	/**
	 * Create a new Idea from database Idea-table and {@link Node}.
	 * 
	 * @param node the {@link Node} to use
	 * @param idea {@link utwente.groep18.dbGen.Idea} to use
	 * @param fieldOfStudy {@link utwente.groep18.dbGen.FieldOfStudy} to use
	 */
	public Idea(Node node, com.myproject.domain.Idea idea, ArrayList<FieldOfStudy> fieldOfStudy) {
		super(node);
		this.archived = idea.getArchived();
		this.fieldsOfStudy = new ArrayList<FieldOfStudy>(fieldOfStudy);
		this.description = new String(idea.getDescription());
		this.image = getImage(idea.getPicture());
		this.votes = new Votes(idea.getUpvotes(), idea.getDownvotes());
	}
	
	/**
	 * Converts a byte[] to an {@linkplain Image}.
	 * 
	 * @param imageBytes data to use
	 * @return the {@linkplain Image}
	 */
	private Image getImage(byte[] imageBytes) {
		InputStream in = new ByteArrayInputStream(imageBytes);
		BufferedImage bImageFromConvert = null;
		try {
			bImageFromConvert = ImageIO.read(in);
		} catch (IOException e) {}
		return bImageFromConvert;
	}
	
	/**
	 * Converts a {@linkplain Image} to a byte[].
	 * 
	 * @param image the {@linkplain Image} to use
	 * @return a byte[] of the image
	 */
	private byte[] toByteArray(Image image) {
		BufferedImage bufferedImage = (BufferedImage)image;
		WritableRaster raster = bufferedImage .getRaster();
		DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
		return data.getData();
	}
	
	/**
	 * Returns whether this idea is archived or not.
	 */
	public boolean isArchived() {
		return archived;
	}
	
	/**
	 * Returns the fields of study associated with this idea.
	 */
	public ArrayList<FieldOfStudy> getFieldsOfStudy() {
		return fieldsOfStudy;
	}
	
	/**
	 * Returns the skills of all fields of study associated with this 
	 * idea.
	 */
	public ArrayList<Skill> getSkills() {
		ArrayList<Skill> skills = new ArrayList<Skill>();
		for (FieldOfStudy fieldOfStudy : fieldsOfStudy) {
			skills.addAll(fieldOfStudy.getSkills());
		}
		return skills;
	}
	
	/**
	 * Returns the description of the idea
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Returns the image belonging to this idea.
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * Returns the {@link Votes} belonging to this idea.
	 */
	public Votes getVotes() {
		return votes;
	}
	
	/**
	 * Archive the idea or not.
	 * @param archived if true archive this idea
	 */
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	/**
	 * Set the id of the node belonging to this idea
	 */
	
	/**
	 * Returns <code>nrOfElements</code> (or less of no more are 
	 * available) {@link Ideas} from the database, sorted to <code>sortType</code>
	 * and in <code>descending</code> order or not.
	 * 
	 * @param sortType the {@link SortType} used 
	 * @param descending whether descending or not
	 * @param nrOfElements number of ideas to return
	 */
	public static ArrayList<Idea> getAllIdeas(SortType sortType, boolean descending, int nrOfElements) {
		SQLQuery query = new SQLQuery(DBConnection.getConnection(), DBConnection.dialect);
		QIdea qIdea = QIdea.idea;
		QNode qNode = QNode.node;
		QComment qComment = QComment.comment;
		List<Tuple> qIdeasAndQNodesAndComments = null;
		switch (sortType) {
		case DATE:
			qIdeasAndQNodesAndComments = query.from(qIdea, qNode)
			.where(qNode.nid.eq(qIdea.nid))
			.where(qNode.nid.eq(qComment.nid))
			.orderBy(descending ? qNode.dateAndTime.desc() : qNode.dateAndTime.asc())
			.list(qIdea, qNode, qComment);
			break;
		case VOTES:
			qIdeasAndQNodesAndComments = query.from(qIdea, qNode, qComment)
			.where(qNode.nid.eq(qIdea.nid))
			.where(qNode.nid.eq(qComment.nid))
			.orderBy(descending ? qIdea.upvotes.desc() : qIdea.upvotes.asc() , descending ? qIdea.downvotes.asc() : qIdea.downvotes.desc())
			.list(qIdea, qNode, qComment);
			break;
		}
		return toIdeas(qIdeasAndQNodesAndComments);
	}
	
	private static ArrayList<Idea> toIdeas(List<Tuple> qIdeasAndQNodesAndComments) {
		ArrayList<Idea> ideas = new ArrayList<Idea>();
		QIdea qIdea = QIdea.idea;
		QNode qNode = QNode.node;
		QComment qComment = QComment.comment;
		for (Tuple tuple : qIdeasAndQNodesAndComments) {
			com.myproject.domain.Idea idea = tuple.get(qIdea);
			com.myproject.domain.Node node = tuple.get(qNode);
			if (node.getCommentsEnabled()) {
				//ideas.add(new Idea(new Node(node), )))
			}
		}			
		return ideas;
	}
	
	public static void addIdea(Idea aIdea, Integer studentNumber) {
		QIdea idea = QIdea.idea;
		QNode node = QNode.node;
		QIdeaFieldOfStudy ifos = QIdeaFieldOfStudy.ideaFieldOfStudy;
		QFieldOfStudy fos = QFieldOfStudy.fieldOfStudy;
		QFieldOfStudySkill fosk = QFieldOfStudySkill.fieldOfStudySkill;
		QSkill skill = QSkill.skill;
		QElaboratedIdeaSkill eis = QElaboratedIdeaSkill.elaboratedIdeaSkill;

		Node aNode = new Node(aIdea);
		ArrayList<FieldOfStudy> fieldsOfStudy = aIdea.getFieldsOfStudy();
		Connection connection = DBConnection.getConnection();
		SQLTemplates dialect = DBConnection.dialect;

		SQLQuery query = new SQLQuery(DBConnection.getConnection(), DBConnection.dialect);
		long nid = query.uniqueResult(SQLExpressions.nextval("node_nid_seq"));
		aIdea.nodeId = (int) nid;

		new SQLInsertClause(connection, dialect, idea)
		.columns(idea.nid, idea.archived, idea.description, idea.picture, idea.upvotes, idea.downvotes)
		.values(nid, aIdea.isArchived(), aIdea.getDescription(), aIdea.toByteArray(aIdea.getImage()), 0, 0)
		.execute();

		new SQLInsertClause(connection, dialect, node)
		.columns(node.nid, node.number, node.title, node.dateAndTime, node.commentsEnabled)
		.values(nid, studentNumber, aNode.getTitle(), aNode.getDateAndTimeLong(), aNode.commentsEnabled())
		.execute();

		if (aIdea instanceof ConcreteIdea){
			ArrayList<Skill> skills = aIdea.getSkills();
			for (Skill sk : skills){
				long skill_id = query.uniqueResult(SQLExpressions.nextval("skill_skill_id_seq"));
				new SQLInsertClause(connection, dialect, skill)
				.columns(skill.skillId, skill.description)
				.values(skill_id, sk.getDescription())
				.execute();
				new SQLInsertClause(connection, dialect, eis)
				.columns(eis.skillId, eis.nid)
				.values(skill_id, nid)
				.execute();
			}
		}
		else {
			for (FieldOfStudy field : fieldsOfStudy) {
				long fid = query.uniqueResult(SQLExpressions.nextval("field_of_study_fid_seq"));
				new SQLInsertClause(connection, dialect, fos)
				.columns(fos.fid, fos.description)
				.values(fid, field.getDescription())
				.execute();
				new SQLInsertClause(connection, dialect, ifos)
				.columns(ifos.nid, ifos.fid)
				.values(nid, fid)
				.execute();
				ArrayList<Skill> skills = field.getSkills();
				for (Skill sk : skills){
					long skill_id = query.uniqueResult(SQLExpressions.nextval("skill_skill_id_seq"));
					new SQLInsertClause(connection, dialect, skill)
					.columns(skill.skillId, skill.description)
					.values(skill_id, sk.getDescription())
					.execute();
					new SQLInsertClause(connection, dialect, fosk)
					.columns(fosk.skillId, fosk.fid)
					.values(skill_id, fid)
					.execute();
				}
			}
		}
	}
	
	public static void deleteIdea() {
		return; //TODO
	}
	
	/**
	 * Checks whether this idea is equal to the supplied object by comparing the fields.
	 * @param o Object to compare to
	 */
	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		if (o != null && o instanceof Idea) {
			Idea i = (Idea) o;
			Node superNode = null;
			try {
				superNode = (Node) super.clone();
			} catch (CloneNotSupportedException e) {
				//Do nothing
			}
			equal = i.getSuper().equals(superNode) && i.isArchived() == archived && i.getDescription() == description &&
					Arrays.equals(i.getFieldsOfStudy().toArray(), fieldsOfStudy.toArray()) && i.getImage().equals(image) && i.getVotes().equals(votes);
		}
		return equal;
	}
	
	/**
	 * Returns the super object of this object.
	 */
	public Node getSuper() {
		try {
			return ((Node) super.clone());
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	/**
	 * Describes the Idea.
	 */
	@Override
	public String toString() {
		return "Idea - (" + super.toString() + "), archived: " + new Boolean(archived).toString() + ", Description: " + description + ", Votes" + votes.toString() + ", Image: " + image.toString() + ", fields of study: " + fieldsOfStudy.toString();
	}
	
}
