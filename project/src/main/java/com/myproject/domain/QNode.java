package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QNode is a Querydsl query type for Node
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QNode extends com.mysema.query.sql.RelationalPathBase<Node> {

    private static final long serialVersionUID = 667050974;

    public static final QNode node = new QNode("node");

    public final BooleanPath commentsEnabled = createBoolean("commentsEnabled");

    public final DatePath<java.sql.Date> dateAndTime = createDate("dateAndTime", java.sql.Date.class);

    public final NumberPath<Integer> nid = createNumber("nid", Integer.class);

    public final StringPath number = createString("number");

    public final StringPath title = createString("title");

    public final com.mysema.query.sql.PrimaryKey<Node> nodePk = createPrimaryKey(nid);

    public final com.mysema.query.sql.ForeignKey<Smd> usersNodeFk = createForeignKey(number, "number");

    public final com.mysema.query.sql.ForeignKey<Comment> _nodeCommentFk = createInvForeignKey(nid, "nid");

    public final com.mysema.query.sql.ForeignKey<Idea> _nodeIdeaFk = createInvForeignKey(nid, "nid");

    public QNode(String variable) {
        super(Node.class, forVariable(variable), "public", "node");
        addMetadata();
    }

    public QNode(String variable, String schema, String table) {
        super(Node.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QNode(Path<? extends Node> path) {
        super(path.getType(), path.getMetadata(), "public", "node");
        addMetadata();
    }

    public QNode(PathMetadata<?> metadata) {
        super(Node.class, metadata, "public", "node");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(commentsEnabled, ColumnMetadata.named("comments_enabled").ofType(-7).withSize(1).notNull());
        addMetadata(dateAndTime, ColumnMetadata.named("date_and_time").ofType(91).withSize(13).notNull());
        addMetadata(nid, ColumnMetadata.named("nid").ofType(4).withSize(10).notNull());
        addMetadata(number, ColumnMetadata.named("number").ofType(12).withSize(9).notNull());
        addMetadata(title, ColumnMetadata.named("title").ofType(12).withSize(255).notNull());
    }

}

