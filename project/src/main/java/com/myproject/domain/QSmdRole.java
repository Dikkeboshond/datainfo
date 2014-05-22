package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QSmdRole is a Querydsl query type for SmdRole
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSmdRole extends com.mysema.query.sql.RelationalPathBase<SmdRole> {

    private static final long serialVersionUID = -613275260;

    public static final QSmdRole smdRole = new QSmdRole("smd_role");

    public final StringPath number = createString("number");

    public final NumberPath<Integer> rid = createNumber("rid", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<SmdRole> smdRolePk = createPrimaryKey(number, rid);

    public final com.mysema.query.sql.ForeignKey<Smd> userUserRoleFk = createForeignKey(number, "number");

    public final com.mysema.query.sql.ForeignKey<Role> roleUserRoleFk = createForeignKey(rid, "rid");

    public QSmdRole(String variable) {
        super(SmdRole.class, forVariable(variable), "public", "smd_role");
        addMetadata();
    }

    public QSmdRole(String variable, String schema, String table) {
        super(SmdRole.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QSmdRole(Path<? extends SmdRole> path) {
        super(path.getType(), path.getMetadata(), "public", "smd_role");
        addMetadata();
    }

    public QSmdRole(PathMetadata<?> metadata) {
        super(SmdRole.class, metadata, "public", "smd_role");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(number, ColumnMetadata.named("number").ofType(12).withSize(9).notNull());
        addMetadata(rid, ColumnMetadata.named("rid").ofType(4).withSize(10).notNull());
    }

}

