package com.s2w.preassignment.attackmanager.presentation.dto.req;

import com.s2w.preassignment.attackmanager.presentation.dto.CveDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CveRequest {
    private List<CveDto> cves;
}
