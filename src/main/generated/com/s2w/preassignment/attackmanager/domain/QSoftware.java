package com.s2w.preassignment.attackmanager.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSoftware is a Querydsl query type for Software
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSoftware extends EntityPathBase<Software> {

    private static final long serialVersionUID = -869719225L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSoftware software = new QSoftware("software");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QSubDomain subDomain;

    public QSoftware(String variable) {
        this(Software.class, forVariable(variable), INITS);
    }

    public QSoftware(Path<? extends Software> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSoftware(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSoftware(PathMetadata metadata, PathInits inits) {
        this(Software.class, metadata, inits);
    }

    public QSoftware(Class<? extends Software> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subDomain = inits.isInitialized("subDomain") ? new QSubDomain(forProperty("subDomain"), inits.get("subDomain")) : null;
    }

}

