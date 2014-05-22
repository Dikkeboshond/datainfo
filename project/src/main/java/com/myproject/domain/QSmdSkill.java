package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QSmdSkill is a Querydsl query type for SmdSkill
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSmdSkill extends com.mysema.query.sql.RelationalPathBase<SmdSkill> {

    private static final long serialVersionUID = -1830862077;

    public static final QSmdSkill smdSkill = new QSmdSkill("smd_skill");

    public final StringPath number = createString("number");

    public final NumberPath<Integer> skillId = createNumber("skillId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<SmdSkill> smdSkillPk = createPrimaryKey(number, skillId);

    public final com.mysema.query.sql.ForeignKey<Smd> smdSmdSkillFk = createForeignKey(number, "number");

    public final com.mysema.query.sql.ForeignKey<Skill> skillSmdSkillFk = createForeignKey(skillId, "skill_id");

    public QSmdSkill(String variable) {
        super(SmdSkill.class, forVariable(variable), "public", "smd_skill");
        addMetadata();
    }

    public QSmdSkill(String variable, String schema, String table) {
        super(SmdSkill.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QSmdSkill(Path<? extends SmdSkill> path) {
        super(path.getType(), path.getMetadata(), "public", "smd_skill");
        addMetadata();
    }

    public QSmdSkill(PathMetadata<?> metadata) {
        super(SmdSkill.class, metadata, "public", "smd_skill");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(number, ColumnMetadata.named("number").ofType(12).withSize(9).notNull());
        addMetadata(skillId, ColumnMetadata.named("skill_id").ofType(4).withSize(10).notNull());
    }

}

