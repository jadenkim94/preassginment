package com.s2w.preassignment.attackmanager.presentation.dto.res;

import com.s2w.preassignment.attackmanager.domain.SubDomain;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SubDomainResponse {
    private final String subDomain;
    private final String ip;
    private final List<String> services;

    private SubDomainResponse(String subDomain, String ip, List<String> services) {
        this.subDomain = subDomain;
        this.ip = ip;
        this.services = services;
    }

    public static SubDomainResponse of(SubDomain subDomain) {
        return new SubDomainResponse(subDomain.getName(), subDomain.getIp(), getSoftwareNames(subDomain));
    }

    private static List<String> getSoftwareNames(SubDomain subDomain) {
        return subDomain.getSoftwares().stream()
                .map(software -> software.getName())
                .collect(Collectors.toList());
    }
}
