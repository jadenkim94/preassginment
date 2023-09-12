package com.s2w.preassignment.attackmanager.adapter.repository.software;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.s2w.preassignment.attackmanager.domain.Software;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.s2w.preassignment.attackmanager.domain.QSoftware.software;
import static com.s2w.preassignment.attackmanager.domain.QSubDomain.subDomain;

@Repository
@RequiredArgsConstructor
public class SoftwareQueryRepositoryImpl implements SoftwareQueryRepository{

    private final JPAQueryFactory queryFactory;
    @Override
    public Page<Software> findSoftwares(String seedId, Pageable pageable) {
        List<Software> softwares = queryFactory
                .select(software)
                .from(software)
                .join(software.subDomain, subDomain)
                .fetchJoin()
                .where(seedIdEqual(seedId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl(softwares, pageable, getTotalCount(seedId));
    }

    private Long getTotalCount(String seedId) {
        return queryFactory.select(software.count())
                .from(software)
                .join(software.subDomain, subDomain)
                .where(seedIdEqual(seedId))
                .fetchOne();
    }

    private static BooleanExpression seedIdEqual(String seedId) {
        return subDomain.seed.seedId.eq(seedId);
    }
}
