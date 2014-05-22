package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QIdea is a Querydsl query type for Idea
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QIdea extends com.mysema.query.sql.RelationalPathBase<Idea> {

    private static final long serialVersionUID = 666891475;

    public static final QIdea idea = new QIdea("idea");

    public final BooleanPath archived = createBoolean("archived");

    public final SimplePath<byte[]> description = createSimple("description", byte[].class);

    public final NumberPath<Integer> downvotes = createNumber("downvotes", Integer.class);

    public final NumberPath<Integer> nid = createNumber("nid", Integer.class);

    public final SimplePath<byte[]> picture = createSimple("picture", byte[].class);

    public final NumberPath<Integer> upvotes = createNumber("upvotes", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<Idea> ideaPk = createPrimaryKey(nid);

    public final com.mysema.query.sql.ForeignKey<Node> nodeIdeaFk = createForeignKey(nid, "nid");

    public final com.mysema.query.sql.ForeignKey<IdeaFieldOfStudy> _ideaIdeaFieldOfStudyFk = createInvForeignKey(nid, "nid");

    public final com.mysema.query.sql.ForeignKey<ElaboratedIdeaSkill> _ideaElaboratedIdeaSkillFk = createInvForeignKey(nid, "nid");

    public QIdea(String variable) {
        super(Idea.class, forVariable(variable), "public", "idea");
        addMetadata();
    }

    public QIdea(String variable, String schema, String table) {
        super(Idea.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QIdea(Path<? extends Idea> path) {
        super(path.getType(), path.getMetadata(), "public", "idea");
        addMetadata();
    }

    public QIdea(PathMetadata<?> metadata) {
        super(Idea.class, metadata, "public", "idea");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(archived, ColumnMetadata.named("archived").ofType(-7).withSize(1).notNull());
        addMetadata(description, ColumnMetadata.named("description").ofType(-2).withSize(2147483647).notNull());
        addMetadata(downvotes, ColumnMetadata.named("downvotes").ofType(4).withSize(10).notNull());
        addMetadata(nid, ColumnMetadata.named("nid").ofType(4).withSize(10).notNull());
        addMetadata(picture, ColumnMetadata.named("picture").ofType(-2).withSize(2147483647));
        addMetadata(upvotes, ColumnMetadata.named("upvotes").ofType(4).withSize(10).notNull());
    }

}

