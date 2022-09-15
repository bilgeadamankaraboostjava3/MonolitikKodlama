package com.boostjava2.MonolitikKodlama.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionExampleController {

    /**
     * !!! DİKKAT !!!
     * Uygulamanız için de mutlaka hataları yakalayabilen bir sistem oluşturmalısınız.
     * @return
     */
    @RequestMapping("/test")
        public String test() {
                throw new RuntimeException("Test exception");
        }
}
