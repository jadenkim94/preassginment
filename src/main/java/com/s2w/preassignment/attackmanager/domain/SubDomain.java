package com.s2w.preassignment.attackmanager.domain;

import com.s2w.preassignment.attackmanager.domain.type.DomainStatus;
import com.s2w.preassignment.attackmanager.domain.type.Ipv4;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SubDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DomainStatus status;
    @Embedded
    private Ipv4 ip;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seed_id")
    private Seed seed;
    @OneToMany(mappedBy = "subDomain")
    private List<Software> softwares = new ArrayList<>();

    @Builder
    private SubDomain(Long id, String name, DomainStatus status, Ipv4 ip, Seed seed, List<Software> softwares) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.ip = ip;
        this.seed = seed;
        this.softwares = softwares;
    }

    public String getIp() {
        return ip.getIp();
    }
}
