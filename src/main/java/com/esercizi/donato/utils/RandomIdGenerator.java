package com.esercizi.donato.utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RandomIdGenerator {
    Map<Integer, LocalDateTime> idMap = new HashMap<>();
    SecureRandom secureRandom = new SecureRandom();

    public RandomIdGenerator() {}

    public Integer generateRandomId() {
        int randomId = Math.abs(secureRandom.nextInt());

        while (idMap.containsKey(randomId)) {
            randomId = Math.abs(secureRandom.nextInt());
        }
        idMap.put(randomId, LocalDateTime.now());
        return randomId;
    }

    public Map<Integer,LocalDateTime> getExistingIds(){
        return idMap;
    }
}
