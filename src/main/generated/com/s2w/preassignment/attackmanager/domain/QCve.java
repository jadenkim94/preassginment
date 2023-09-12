package com.s2w.preassignment.attackmanager.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCve is a Querydsl query type for Cve
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCve extends EntityPathBase<Cve> {

    private static final long serialVersionUID = 1561410738L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCve cve = new QCve("cve");

    public final StringPath cveCode = createString("cveCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSoftware software;

    public QCve(String variable) {
        this(Cve.class, forVariable(variable), INITS);
    }

    public QCve(Path<? extends Cve> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCve(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCve(PathMetadata metadata, PathInits inits) {
        this(Cve.class, metadata, inits);
    }

    public QCve(Class<? extends Cve> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.software = inits.isInitialized("software") ? new QSoftware(forProperty("software"), inits.get("software")) : null;
    }

}

