package com.farukkaradeniz.cachepractising;

import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class MyService {

    @Cacheable(value = "1minCache")
    @SneakyThrows
    public String get1Min() {
        System.out.println("Entered get1Min: " + OffsetDateTime.now());
        Thread.sleep(3_000);
        System.out.println("Data loaded get1Min: " + OffsetDateTime.now());
        return "1Min";
    }

    @Cacheable(value = "2minCache")
    @SneakyThrows
    public String get2Min() {
        System.out.println("Entered get2Min: " + OffsetDateTime.now());
        Thread.sleep(3_000);
        System.out.println("Data loaded get2Min: " + OffsetDateTime.now());
        return "2Min";
    }

    @Cacheable(value = "30secCache")
    @SneakyThrows
    public String get30Sec() {
        System.out.println("Entered get30Sec: " + OffsetDateTime.now());
        Thread.sleep(3_000);
        System.out.println("Data loaded get30Sec: " + OffsetDateTime.now());
        return "30sec";
    }
}
