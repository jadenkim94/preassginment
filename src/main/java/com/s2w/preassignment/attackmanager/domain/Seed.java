package com.s2w.preassignment.attackmanager.domain;

import com.s2w.preassignment.attackmanager.domain.util.SeedIdCreator;
import com.s2w.preassignment.attackmanager.exception.ApplicationException;
import com.s2w.preassignment.attackmanager.exception.ErrorType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Seed {
    private static final String SEED_ID_PREFIX = "seed_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String seedId;
    private String name;

    @Builder
    private Seed(Long id, String seedId, String name) {
        validateSeedId(seedId);
        this.id = id;
        this.seedId = seedId;
        this.name = name;
    }

    private void validateSeedId(String seedId) {
        if(seedId.length() != 15) {
            throw new ApplicationException(ErrorType.INVALID_SEED_ID_LENGTH);
        }
        if(!seedId.startsWith(SEED_ID_PREFIX)) {
            throw new ApplicationException(ErrorType.INVALID_SEED_ID_PREFIX);
        }
    }

    public static Seed createSeed(String name) {
        return Seed.builder()
                .seedId(SeedIdCreator.createId())
                .name(name)
                .build();
    }
}
