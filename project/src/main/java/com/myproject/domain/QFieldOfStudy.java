package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QFieldOfStudy is a Querydsl query type for FieldOfStudy
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QFieldOfStudy extends com.mysema.query.sql.RelationalPathBase<FieldOfStudy> {

    private static final long serialVersionUID = 824115636;

    public static final QFieldOfStudy fieldOfStudy = new QFieldOfStudy("field_of_study");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> fid = createNumber("fid", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<FieldOfStudy> fieldOfStudyPk = createPrimaryKey(fid);

    public final com.mysema.query.sql.ForeignKey<IdeaFieldOfStudy> _fieldOfStudyIdeaFieldOfStudyFk = createInvForeignKey(fid, "fid");

    public final com.mysema.query.sql.ForeignKey<FieldOfStudySkill> _fieldOfStudyFieldOfStudySkillFk = createInvForeignKey(fid, "fid");

    public QFieldOfStudy(String variable) {
        super(FieldOfStudy.class, forVariable(variable), "public", "field_of_study");
        addMetadata();
    }

    public QFieldOfStudy(String variable, String schema, String table) {
        super(FieldOfStudy.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QFieldOfStudy(Path<? extends FieldOfStudy> path) {
        super(path.getType(), path.getMetadata(), "public", "field_of_study");
        addMetadata();
    }

    public QFieldOfStudy(PathMetadata<?> metadata) {
        super(FieldOfStudy.class, metadata, "public", "field_of_study");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("description").ofType(12).withSize(2147483647).notNull());
        addMetadata(fid, ColumnMetadata.named("fid").ofType(4).withSize(10).notNull());
    }

}

