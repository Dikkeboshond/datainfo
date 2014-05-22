package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QRole extends com.mysema.query.sql.RelationalPathBase<Role> {

    private static final long serialVersionUID = 667170386;

    public static final QRole role = new QRole("role");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> rid = createNumber("rid", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<Role> rolePk = createPrimaryKey(rid);

    public final com.mysema.query.sql.ForeignKey<SmdRole> _roleUserRoleFk = createInvForeignKey(rid, "rid");

    public QRole(String variable) {
        super(Role.class, forVariable(variable), "public", "role");
        addMetadata();
    }

    public QRole(String variable, String schema, String table) {
        super(Role.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata(), "public", "role");
        addMetadata();
    }

    public QRole(PathMetadata<?> metadata) {
        super(Role.class, metadata, "public", "role");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("description").ofType(12).withSize(255).notNull());
        addMetadata(rid, ColumnMetadata.named("rid").ofType(4).withSize(10).notNull());
    }

}

