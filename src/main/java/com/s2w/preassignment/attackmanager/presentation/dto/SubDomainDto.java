package com.s2w.preassignment.attackmanager.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SubDomainDto {
    private String name;
    private String status;
    private String ip;
    @JsonProperty("softwares")
    private List<String> softwareNames;
}
