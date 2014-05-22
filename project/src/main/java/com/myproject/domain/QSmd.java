package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QSmd is a Querydsl query type for Smd
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSmd extends com.mysema.query.sql.RelationalPathBase<Smd> {

    private static final long serialVersionUID = 991353838;

    public static final QSmd smd = new QSmd("smd");

    public final DatePath<java.sql.Date> dateAndTime = createDate("dateAndTime", java.sql.Date.class);

    public final StringPath fullName = createString("fullName");

    public final StringPath number = createString("number");

    public final com.mysema.query.sql.PrimaryKey<Smd> smdNumber = createPrimaryKey(number);

    public final com.mysema.query.sql.ForeignKey<SmdRole> _userUserRoleFk = createInvForeignKey(number, "number");

    public final com.mysema.query.sql.ForeignKey<SmdSkill> _smdSmdSkillFk = createInvForeignKey(number, "number");

    public final com.mysema.query.sql.ForeignKey<Comment> _userCommentFk = createInvForeignKey(number, "number");

    public final com.mysema.query.sql.ForeignKey<Node> _usersNodeFk = createInvForeignKey(number, "number");

    public QSmd(String variable) {
        super(Smd.class, forVariable(variable), "public", "smd");
        addMetadata();
    }

    public QSmd(String variable, String schema, String table) {
        super(Smd.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QSmd(Path<? extends Smd> path) {
        super(path.getType(), path.getMetadata(), "public", "smd");
        addMetadata();
    }

    public QSmd(PathMetadata<?> metadata) {
        super(Smd.class, metadata, "public", "smd");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(dateAndTime, ColumnMetadata.named("date_and_time").ofType(91).withSize(13).notNull());
        addMetadata(fullName, ColumnMetadata.named("full_name").ofType(12).withSize(255).notNull());
        addMetadata(number, ColumnMetadata.named("number").ofType(12).withSize(9).notNull());
    }

}

