package com.s2w.preassignment.attackmanager.application;

import com.s2w.preassignment.attackmanager.adapter.repository.subdomain.SubDomainRepository;
import com.s2w.preassignment.attackmanager.domain.SubDomain;
import com.s2w.preassignment.attackmanager.presentation.api.Pagination;
import com.s2w.preassignment.attackmanager.presentation.dto.res.SubDomainResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubdomainService {

    private final SubDomainRepository subDomainRepository;

    public Pagination<SubDomainResponse> findSubDomains(String seedId, Pageable pageable) {
        SeedIdValidator.validateExistSeed(seedId);
        Page<SubDomain> subDomainPage = subDomainRepository.findBySeedId(seedId, pageable);
        List<SubDomain> subDomains = subDomainPage.getContent();
        List<SubDomainResponse> subDomainResponses = getSubDomainResponses(subDomains);

        return Pagination.of(subDomainResponses, subDomainPage);
    }

    private List<SubDomainResponse> getSubDomainResponses(List<SubDomain> subDomains) {
        return subDomains.stream()
                .map(subdomain -> SubDomainResponse.of(subdomain))
                .collect(Collectors.toList());
    }
}
