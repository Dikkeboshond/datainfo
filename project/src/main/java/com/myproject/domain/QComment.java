package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QComment extends com.mysema.query.sql.RelationalPathBase<Comment> {

    private static final long serialVersionUID = -1862067453;

    public static final QComment comment = new QComment("comment");

    public final SimplePath<byte[]> body = createSimple("body", byte[].class);

    public final DatePath<java.sql.Date> dateAndTime = createDate("dateAndTime", java.sql.Date.class);

    public final NumberPath<Integer> downvotes = createNumber("downvotes", Integer.class);

    public final NumberPath<Integer> nid = createNumber("nid", Integer.class);

    public final StringPath number = createString("number");

    public final NumberPath<Integer> upvotes = createNumber("upvotes", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<Comment> commentPk = createPrimaryKey(nid);

    public final com.mysema.query.sql.ForeignKey<Node> nodeCommentFk = createForeignKey(nid, "nid");

    public final com.mysema.query.sql.ForeignKey<Smd> userCommentFk = createForeignKey(number, "number");

    public QComment(String variable) {
        super(Comment.class, forVariable(variable), "public", "comment");
        addMetadata();
    }

    public QComment(String variable, String schema, String table) {
        super(Comment.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QComment(Path<? extends Comment> path) {
        super(path.getType(), path.getMetadata(), "public", "comment");
        addMetadata();
    }

    public QComment(PathMetadata<?> metadata) {
        super(Comment.class, metadata, "public", "comment");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(body, ColumnMetadata.named("body").ofType(-2).withSize(2147483647).notNull());
        addMetadata(dateAndTime, ColumnMetadata.named("date_and_time").ofType(91).withSize(13).notNull());
        addMetadata(downvotes, ColumnMetadata.named("downvotes").ofType(4).withSize(10).notNull());
        addMetadata(nid, ColumnMetadata.named("nid").ofType(4).withSize(10).notNull());
        addMetadata(number, ColumnMetadata.named("number").ofType(12).withSize(9).notNull());
        addMetadata(upvotes, ColumnMetadata.named("upvotes").ofType(4).withSize(10).notNull());
    }

}

