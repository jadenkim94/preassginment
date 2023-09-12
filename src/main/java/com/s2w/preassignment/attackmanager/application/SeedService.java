package com.s2w.preassignment.attackmanager.application;

import com.s2w.preassignment.attackmanager.adapter.repository.seed.SeedRepository;
import com.s2w.preassignment.attackmanager.adapter.repository.software.SoftwareRepository;
import com.s2w.preassignment.attackmanager.adapter.repository.subdomain.SubDomainRepository;
import com.s2w.preassignment.attackmanager.domain.Seed;
import com.s2w.preassignment.attackmanager.domain.Software;
import com.s2w.preassignment.attackmanager.domain.SubDomain;
import com.s2w.preassignment.attackmanager.presentation.dto.req.SeedSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class SeedService {

    private final SeedRepository seedRepository;
    private final SubDomainRepository subDomainRepository;
    private final SoftwareRepository softwareRepository;

    public String save(SeedSaveRequest request) {
        Seed seed = saveSeed(request);
        List<SubDomain> subDomains = saveSubDomains(request, seed);
        saveSoftwares(request, subDomains);
        return seed.getSeedId();
    }

    private void saveSoftwares(SeedSaveRequest request, List<SubDomain> subDomains) {
        List<Software> softwares = request.toSoftwares(subDomainMapByName(subDomains));
        softwareRepository.saveAll(softwares);
    }

    private Map<String, SubDomain> subDomainMapByName(List<SubDomain> subDomains) {
        Map<String, SubDomain> subDomainHashMap = new HashMap<>();
        subDomains.stream()
                .forEach(subDomain -> subDomainHashMap.put(subDomain.getName(), subDomain));

        return subDomainHashMap;
    }

    private List<SubDomain> saveSubDomains(SeedSaveRequest request, Seed seed) {
        List<SubDomain> subDomains = request.toSubDomains(seed);
        subDomainRepository.saveAll(subDomains);
        return subDomains;
    }

    private Seed saveSeed(SeedSaveRequest request) {
        Seed seed = Seed.createSeed(request.getSeedName());
        seedRepository.save(seed);
        return seed;
    }
}
