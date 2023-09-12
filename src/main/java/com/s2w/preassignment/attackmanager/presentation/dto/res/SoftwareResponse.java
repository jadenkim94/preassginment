package com.s2w.preassignment.attackmanager.presentation.dto.res;

import com.s2w.preassignment.attackmanager.domain.Software;
import lombok.Getter;

@Getter
public class SoftwareResponse {
    private final String software;

    private SoftwareResponse(String software) {
        this.software = software;
    }

    public static SoftwareResponse of(Software software) {
        return new SoftwareResponse(software.getName());
    }
}
