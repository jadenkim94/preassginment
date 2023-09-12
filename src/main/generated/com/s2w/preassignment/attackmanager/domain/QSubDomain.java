package com.s2w.preassignment.attackmanager.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubDomain is a Querydsl query type for SubDomain
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubDomain extends EntityPathBase<SubDomain> {

    private static final long serialVersionUID = 39141764L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubDomain subDomain = new QSubDomain("subDomain");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.s2w.preassignment.attackmanager.domain.type.QIpv4 ip;

    public final StringPath name = createString("name");

    public final QSeed seed;

    public final ListPath<Software, QSoftware> softwares = this.<Software, QSoftware>createList("softwares", Software.class, QSoftware.class, PathInits.DIRECT2);

    public final EnumPath<com.s2w.preassignment.attackmanager.domain.type.DomainStatus> status = createEnum("status", com.s2w.preassignment.attackmanager.domain.type.DomainStatus.class);

    public QSubDomain(String variable) {
        this(SubDomain.class, forVariable(variable), INITS);
    }

    public QSubDomain(Path<? extends SubDomain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubDomain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubDomain(PathMetadata metadata, PathInits inits) {
        this(SubDomain.class, metadata, inits);
    }

    public QSubDomain(Class<? extends SubDomain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ip = inits.isInitialized("ip") ? new com.s2w.preassignment.attackmanager.domain.type.QIpv4(forProperty("ip")) : null;
        this.seed = inits.isInitialized("seed") ? new QSeed(forProperty("seed")) : null;
    }

}

