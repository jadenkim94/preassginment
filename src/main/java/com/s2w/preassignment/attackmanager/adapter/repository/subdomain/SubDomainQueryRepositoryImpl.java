package com.s2w.preassignment.attackmanager.adapter.repository.subdomain;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.s2w.preassignment.attackmanager.domain.SubDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.s2w.preassignment.attackmanager.domain.QSoftware.software;
import static com.s2w.preassignment.attackmanager.domain.QSubDomain.subDomain;

@Repository
@RequiredArgsConstructor
public class SubDomainQueryRepositoryImpl implements SubDomainQueryRepository {

    private final JPAQueryFactory queryFactory;

    public PageImpl findBySeedId(String seedId, Pageable pageable) {
        List<SubDomain> subDomains = queryFactory.selectFrom(subDomain)
                .leftJoin(subDomain.softwares, software)
                .fetchJoin()
                .where(seedIdEqual(seedId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = getTotalCount(seedId);

        return new PageImpl(subDomains, pageable, total);
    }

    private Long getTotalCount(String seedId) {
        return queryFactory.select(subDomain.count())
                .from(subDomain)
                .where(seedIdEqual(seedId))
                .fetchOne();
    }

    private BooleanExpression seedIdEqual(String seedId) {
        return subDomain.seed.seedId.eq(seedId);
    }
}
