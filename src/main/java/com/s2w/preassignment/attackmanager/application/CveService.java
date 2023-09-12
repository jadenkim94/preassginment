package com.s2w.preassignment.attackmanager.application;

import com.s2w.preassignment.attackmanager.adapter.repository.cve.CveRepository;
import com.s2w.preassignment.attackmanager.domain.Cve;
import com.s2w.preassignment.attackmanager.presentation.api.Pagination;
import com.s2w.preassignment.attackmanager.presentation.dto.CveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CveService {

    private final CveRepository cveRepository;

    public Pagination findCves(String seedId, Pageable pageable) {
        SeedIdValidator.validateExistSeed(seedId);
        Page<Cve> cevPage = cveRepository.findCvesDistinctBySoftwareName(seedId, pageable);

        Map<String, ArrayList<Cve>> cveMapByCode = getCveMapByCode(cevPage.getContent());

        List<CveDto> cveDtos = cveMapByCode.keySet().stream()
                .map(cveCode -> CveDto.of(cveCode, cveMapByCode.get(cveCode)))
                .collect(Collectors.toList());

        return Pagination.of(cveDtos, cevPage);
    }

    private Map<String, ArrayList<Cve>> getCveMapByCode(List<Cve> cves) {
        Map<String, ArrayList<Cve>> cveMapByCode = new HashMap<>();

        for (Cve cve : cves) {
            cveMapByCode.computeIfAbsent(cve.getCveCode(), k -> new ArrayList<>()).add(cve);
        }

        return cveMapByCode;
    }
}
