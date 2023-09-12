package com.s2w.preassignment.attackmanager.adapter.repository.subdomain;

import com.s2w.preassignment.attackmanager.domain.SubDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubDomainRepository extends JpaRepository<SubDomain, Long>, SubDomainQueryRepository {
}
