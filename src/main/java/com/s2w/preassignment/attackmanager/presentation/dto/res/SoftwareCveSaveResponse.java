package com.s2w.preassignment.attackmanager.presentation.dto.res;

import lombok.Getter;

import java.util.List;

@Getter
public class SoftwareCveSaveResponse {
    public static final String UN_EXIST_SOFTWARE_MESSAGE = "unExistSoftwares 에 해당하는 소프트웨어들을 사용하는 서브도메인이 존재하지 않아 해당 소프트웨어에 대한 CVE 정보를 제외한 CVE 정보만 저장됩니다.";

    private final List<String> unExistSoftwares;

    private SoftwareCveSaveResponse(List<String> unExistSoftwares) {
        this.unExistSoftwares = unExistSoftwares;
    }

    public static SoftwareCveSaveResponse of(List<String> unExistSoftwares) {
        return new SoftwareCveSaveResponse(unExistSoftwares);
    }
}
