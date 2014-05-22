package com.myproject.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;




/**
 * QIdeaFieldOfStudy is a Querydsl query type for IdeaFieldOfStudy
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QIdeaFieldOfStudy extends com.mysema.query.sql.RelationalPathBase<IdeaFieldOfStudy> {

    private static final long serialVersionUID = -1384018869;

    public static final QIdeaFieldOfStudy ideaFieldOfStudy = new QIdeaFieldOfStudy("idea_field_of_study");

    public final NumberPath<Integer> fid = createNumber("fid", Integer.class);

    public final NumberPath<Integer> nid = createNumber("nid", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<IdeaFieldOfStudy> ideaFieldOfStudyPk = createPrimaryKey(nid, fid);

    public final com.mysema.query.sql.ForeignKey<Idea> ideaIdeaFieldOfStudyFk = createForeignKey(nid, "nid");

    public final com.mysema.query.sql.ForeignKey<FieldOfStudy> fieldOfStudyIdeaFieldOfStudyFk = createForeignKey(fid, "fid");

    public QIdeaFieldOfStudy(String variable) {
        super(IdeaFieldOfStudy.class, forVariable(variable), "public", "idea_field_of_study");
        addMetadata();
    }

    public QIdeaFieldOfStudy(String variable, String schema, String table) {
        super(IdeaFieldOfStudy.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QIdeaFieldOfStudy(Path<? extends IdeaFieldOfStudy> path) {
        super(path.getType(), path.getMetadata(), "public", "idea_field_of_study");
        addMetadata();
    }

    public QIdeaFieldOfStudy(PathMetadata<?> metadata) {
        super(IdeaFieldOfStudy.class, metadata, "public", "idea_field_of_study");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(fid, ColumnMetadata.named("fid").ofType(4).withSize(10).notNull());
        addMetadata(nid, ColumnMetadata.named("nid").ofType(4).withSize(10).notNull());
    }

}

