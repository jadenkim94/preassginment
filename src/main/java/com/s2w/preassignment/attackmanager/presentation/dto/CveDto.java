package com.s2w.preassignment.attackmanager.presentation.dto;

import com.s2w.preassignment.attackmanager.domain.Cve;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CveDto {
    private String cveCode;
    private List<String> softwares;

    private CveDto(String cveCode, List<String> softwares) {
        this.cveCode = cveCode;
        this.softwares = softwares;
    }

    public static CveDto of(String cveCode, ArrayList<Cve> cves) {
        List<String> softwareNames = cves.stream()
                .map(it -> it.getSoftwareName())
                .collect(Collectors.toList());

        return new CveDto(cveCode, softwareNames);
    }
}
