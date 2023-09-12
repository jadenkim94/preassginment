package com.s2w.preassignment.attackmanager.application;

import com.s2w.preassignment.attackmanager.adapter.repository.cve.CveRepository;
import com.s2w.preassignment.attackmanager.adapter.repository.software.SoftwareRepository;
import com.s2w.preassignment.attackmanager.domain.Cve;
import com.s2w.preassignment.attackmanager.domain.Software;
import com.s2w.preassignment.attackmanager.presentation.api.Pagination;
import com.s2w.preassignment.attackmanager.presentation.dto.req.CveRequest;
import com.s2w.preassignment.attackmanager.presentation.dto.res.SoftwareCveSaveResponse;
import com.s2w.preassignment.attackmanager.presentation.dto.res.SoftwareResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class SoftwareService {

    private final SoftwareRepository softwareRepository;
    private final CveRepository cveRepository;

    @Transactional(readOnly = true)
    public Pagination<SoftwareResponse> findSoftwares(String seedId, Pageable pageable) {
        SeedIdValidator.validateExistSeed(seedId);
        Page<Software> softwarePage = softwareRepository.findSoftwares(seedId, pageable);
        List<Software> softwares = softwarePage.getContent();
        List<SoftwareResponse> softwareResponses =
                softwares.stream()
                        .map(software -> SoftwareResponse.of(software))
                        .collect(Collectors.toList());

        return Pagination.of(softwareResponses, softwarePage);
    }

    public SoftwareCveSaveResponse saveSoftwareCves(CveRequest request) {
        List<String> notExistSoftwares = new ArrayList<>();

        List<Cve> newCves = request.getCves().stream()
                .flatMap(dto -> dto.getSoftwares().stream()
                        .flatMap(softwareName -> {
                            List<Software> existSoftware = softwareRepository.findByName(softwareName);

                            if (!existSoftware.isEmpty()) {
                                return existSoftware.stream().map(software -> Cve.builder()
                                        .cveCode(dto.getCveCode())
                                        .software(software)
                                        .build());
                            } else {
                                notExistSoftwares.add(softwareName);
                                return Stream.empty();
                            }
                        }))
                .collect(Collectors.toList());

        cveRepository.saveAll(newCves);

        return SoftwareCveSaveResponse.of(notExistSoftwares);
    }
}
