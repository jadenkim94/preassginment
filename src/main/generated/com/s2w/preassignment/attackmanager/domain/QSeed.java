package com.s2w.preassignment.attackmanager.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeed is a Querydsl query type for Seed
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeed extends EntityPathBase<Seed> {

    private static final long serialVersionUID = 1159553041L;

    public static final QSeed seed = new QSeed("seed");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath seedId = createString("seedId");

    public QSeed(String variable) {
        super(Seed.class, forVariable(variable));
    }

    public QSeed(Path<? extends Seed> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeed(PathMetadata metadata) {
        super(Seed.class, metadata);
    }

}

