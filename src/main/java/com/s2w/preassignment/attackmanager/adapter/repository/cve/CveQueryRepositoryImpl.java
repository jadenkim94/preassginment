package com.s2w.preassignment.attackmanager.adapter.repository.cve;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.s2w.preassignment.attackmanager.domain.Cve;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.s2w.preassignment.attackmanager.domain.QCve.cve;
import static com.s2w.preassignment.attackmanager.domain.QSoftware.software;
import static com.s2w.preassignment.attackmanager.domain.QSubDomain.subDomain;

@Repository
@RequiredArgsConstructor
public class CveQueryRepositoryImpl implements CveQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Cve> findCvesDistinctBySoftwareName(String seedId, Pageable pageable) {
        List<Cve> cves = queryFactory.select(cve)
                .from(cve)
                .join(cve.software, software)
                .fetchJoin()
                .join(software.subDomain, subDomain)
                .fetchJoin()
                .where(seedIdEqual(seedId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl(distinctBySoftwareName(cves), pageable, getTotalCount(seedId));
    }

    private BooleanExpression seedIdEqual(String seedId) {
        return subDomain.seed.seedId.eq(seedId);
    }

    private Long getTotalCount(String seedId) {
        return queryFactory.select(cve.count())
                .from(cve)
                .join(cve.software, software)
                .join(software.subDomain, subDomain)
                .where(seedIdEqual(seedId))
                .fetchOne();
    }

    private List distinctBySoftwareName(List<Cve> inputList) {
        Map<String, Cve> cveMapBySoftwareName = new HashMap<>();
        List<Cve> cves = new ArrayList<>();

        for (Cve item : inputList) {
            String softwareName = item.getSoftwareName();
            if (!cveMapBySoftwareName.containsKey(softwareName)) {
                cveMapBySoftwareName.put(softwareName, item);
                cves.add(item);
            }
        }
        return cves;
    }
}




