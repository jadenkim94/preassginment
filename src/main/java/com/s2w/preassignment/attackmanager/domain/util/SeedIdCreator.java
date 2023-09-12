package com.s2w.preassignment.attackmanager.domain.util;

import java.util.UUID;

public class SeedIdCreator {

    private static final String PREFIX = "seed_";

    public static String createId() {
        String uuidString = UUID.randomUUID().toString();
        return PREFIX + uuidString.replace("-", "").substring(0, 10);
    }
}
