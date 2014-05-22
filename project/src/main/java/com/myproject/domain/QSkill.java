package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QSkill is a Querydsl query type for Skill
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSkill extends com.mysema.query.sql.RelationalPathBase<Skill> {

    private static final long serialVersionUID = -791752715;

    public static final QSkill skill = new QSkill("skill");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> skillId = createNumber("skillId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<Skill> skillPk = createPrimaryKey(skillId);

    public final com.mysema.query.sql.ForeignKey<ElaboratedIdeaSkill> _skillIdeaSkillFk = createInvForeignKey(skillId, "skill_id");

    public final com.mysema.query.sql.ForeignKey<FieldOfStudySkill> _skillFieldOfStudySkillFk = createInvForeignKey(skillId, "skill_id");

    public final com.mysema.query.sql.ForeignKey<SmdSkill> _skillSmdSkillFk = createInvForeignKey(skillId, "skill_id");

    public QSkill(String variable) {
        super(Skill.class, forVariable(variable), "public", "skill");
        addMetadata();
    }

    public QSkill(String variable, String schema, String table) {
        super(Skill.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QSkill(Path<? extends Skill> path) {
        super(path.getType(), path.getMetadata(), "public", "skill");
        addMetadata();
    }

    public QSkill(PathMetadata<?> metadata) {
        super(Skill.class, metadata, "public", "skill");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("description").ofType(12).withSize(255).notNull());
        addMetadata(skillId, ColumnMetadata.named("skill_id").ofType(4).withSize(10).notNull());
    }

}

