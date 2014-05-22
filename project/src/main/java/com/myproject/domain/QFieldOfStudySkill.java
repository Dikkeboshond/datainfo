package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QFieldOfStudySkill is a Querydsl query type for FieldOfStudySkill
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QFieldOfStudySkill extends com.mysema.query.sql.RelationalPathBase<FieldOfStudySkill> {

    private static final long serialVersionUID = -1761228547;

    public static final QFieldOfStudySkill fieldOfStudySkill = new QFieldOfStudySkill("field_of_study_skill");

    public final NumberPath<Integer> fid = createNumber("fid", Integer.class);

    public final NumberPath<Integer> skillId = createNumber("skillId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<FieldOfStudySkill> fieldOfStudySkillPk = createPrimaryKey(fid, skillId);

    public final com.mysema.query.sql.ForeignKey<Skill> skillFieldOfStudySkillFk = createForeignKey(skillId, "skill_id");

    public final com.mysema.query.sql.ForeignKey<FieldOfStudy> fieldOfStudyFieldOfStudySkillFk = createForeignKey(fid, "fid");

    public QFieldOfStudySkill(String variable) {
        super(FieldOfStudySkill.class, forVariable(variable), "public", "field_of_study_skill");
        addMetadata();
    }

    public QFieldOfStudySkill(String variable, String schema, String table) {
        super(FieldOfStudySkill.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QFieldOfStudySkill(Path<? extends FieldOfStudySkill> path) {
        super(path.getType(), path.getMetadata(), "public", "field_of_study_skill");
        addMetadata();
    }

    public QFieldOfStudySkill(PathMetadata<?> metadata) {
        super(FieldOfStudySkill.class, metadata, "public", "field_of_study_skill");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(fid, ColumnMetadata.named("fid").ofType(4).withSize(10).notNull());
        addMetadata(skillId, ColumnMetadata.named("skill_id").ofType(4).withSize(10).notNull());
    }

}

