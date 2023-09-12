package com.s2w.preassignment.attackmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cve {

    @Id
    @GeneratedValue
    private Long id;
    private String cveCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private Software software;

    @Builder
    private Cve(Long id, String cveCode, Software software) {
        this.id = id;
        this.cveCode = cveCode;
        this.software = software;
    }

    public String getSoftwareName() {
        return software.getName();
    }
}
