package com.s2w.preassignment.attackmanager.adapter.repository.subdomain;

import com.s2w.preassignment.attackmanager.domain.SubDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubDomainQueryRepository {
    Page<SubDomain> findBySeedId(String seedId, Pageable pageable);
}
