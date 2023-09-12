package com.s2w.preassignment.attackmanager.application;

import com.s2w.preassignment.attackmanager.adapter.repository.seed.SeedRepository;
import com.s2w.preassignment.attackmanager.exception.ErrorType;
import com.s2w.preassignment.attackmanager.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeedIdValidator {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static void validateExistSeed(String seedId) {
        SeedRepository seedRepository = applicationContext.getBean(SeedRepository.class);
        if (!seedRepository.existsBySeedId(seedId)) {
            throw new ApplicationException(ErrorType.NOT_FOUND_SEED_ID);
        }
    }
}
