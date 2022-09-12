package com.farukkaradeniz.cachepractising;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @SneakyThrows
    public String get1Min() {
        System.out.println("Entered get1Min");
        Thread.sleep(3_000);
        System.out.println("Data loaded get1Min");
        return "1Min";
    }

    @SneakyThrows
    public String get2Min() {
        System.out.println("Entered get2Min");
        Thread.sleep(3_000);
        System.out.println("Data loaded get2Min");
        return "2Min";
    }

    @SneakyThrows
    public String get30Sec() {
        System.out.println("Entered get30Sec");
        Thread.sleep(3_000);
        System.out.println("Data loaded get30Sec");
        return "30sec";
    }
}
