package com.s2w.preassignment.attackmanager.domain.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QIpv4 is a Querydsl query type for Ipv4
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QIpv4 extends BeanPath<Ipv4> {

    private static final long serialVersionUID = -672181575L;

    public static final QIpv4 ipv4 = new QIpv4("ipv4");

    public final StringPath ip = createString("ip");

    public QIpv4(String variable) {
        super(Ipv4.class, forVariable(variable));
    }

    public QIpv4(Path<? extends Ipv4> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIpv4(PathMetadata metadata) {
        super(Ipv4.class, metadata);
    }

}

