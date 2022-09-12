package com.farukkaradeniz.cachepractising;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private MyService myService;

    public Controller(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/min1")
    public String get1Min() {
        return myService.get1Min();
    }

    @GetMapping("/min2")
    public String get2Min() {
        return myService.get2Min();
    }

    @GetMapping("/sec30")
    public String get30Sec() {
        return myService.get30Sec();
    }
}
