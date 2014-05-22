package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QElaboratedIdeaSkill is a Querydsl query type for ElaboratedIdeaSkill
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QElaboratedIdeaSkill extends com.mysema.query.sql.RelationalPathBase<ElaboratedIdeaSkill> {

    private static final long serialVersionUID = -126759103;

    public static final QElaboratedIdeaSkill elaboratedIdeaSkill = new QElaboratedIdeaSkill("elaborated_idea_skill");

    public final NumberPath<Integer> nid = createNumber("nid", Integer.class);

    public final NumberPath<Integer> skillId = createNumber("skillId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ElaboratedIdeaSkill> elaboratedIdeaSkillPk = createPrimaryKey(nid, skillId);

    public final com.mysema.query.sql.ForeignKey<Skill> skillIdeaSkillFk = createForeignKey(skillId, "skill_id");

    public final com.mysema.query.sql.ForeignKey<Idea> ideaElaboratedIdeaSkillFk = createForeignKey(nid, "nid");

    public QElaboratedIdeaSkill(String variable) {
        super(ElaboratedIdeaSkill.class, forVariable(variable), "public", "elaborated_idea_skill");
        addMetadata();
    }

    public QElaboratedIdeaSkill(String variable, String schema, String table) {
        super(ElaboratedIdeaSkill.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QElaboratedIdeaSkill(Path<? extends ElaboratedIdeaSkill> path) {
        super(path.getType(), path.getMetadata(), "public", "elaborated_idea_skill");
        addMetadata();
    }

    public QElaboratedIdeaSkill(PathMetadata<?> metadata) {
        super(ElaboratedIdeaSkill.class, metadata, "public", "elaborated_idea_skill");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(nid, ColumnMetadata.named("nid").ofType(4).withSize(10).notNull());
        addMetadata(skillId, ColumnMetadata.named("skill_id").ofType(4).withSize(10).notNull());
    }

}

