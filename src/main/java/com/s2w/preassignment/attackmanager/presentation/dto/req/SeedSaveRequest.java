package com.s2w.preassignment.attackmanager.presentation.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.s2w.preassignment.attackmanager.domain.Seed;
import com.s2w.preassignment.attackmanager.domain.Software;
import com.s2w.preassignment.attackmanager.domain.SubDomain;
import com.s2w.preassignment.attackmanager.domain.type.DomainStatus;
import com.s2w.preassignment.attackmanager.domain.type.Ipv4;
import com.s2w.preassignment.attackmanager.presentation.dto.SubDomainDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SeedSaveRequest {
    private String seedName;
    @JsonProperty("subDomains")
    private List<SubDomainDto> subDomainDtos;

    public SeedSaveRequest(String seedName, List<SubDomainDto> subDomainDtos) {
        this.seedName = seedName;
        this.subDomainDtos = subDomainDtos;
    }

    public List<SubDomain> toSubDomains(Seed seed) {
        return subDomainDtos.stream()
                .map(dto -> SubDomain.builder()
                        .seed(seed)
                        .name(dto.getName())
                        .ip(Ipv4.createIpv4(dto.getIp()))
                        .status(DomainStatus.valueOf(dto.getStatus()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<Software> toSoftwares(Map<String, SubDomain> subDomainMap) {
        List<Software> softwares = new ArrayList<>();

        subDomainDtos.stream()
                .forEach(dto -> dto.getSoftwareNames().stream()
                        .forEach(name -> {
                            Software software = Software.builder()
                                    .name(name)
                                    .subDomain(subDomainMap.get(dto.getName()))
                                    .build();
                            softwares.add(software);
                        }));

        return softwares;
    }


}
