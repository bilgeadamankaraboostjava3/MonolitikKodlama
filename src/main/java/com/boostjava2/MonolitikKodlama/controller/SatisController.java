package com.boostjava2.MonolitikKodlama.controller;

import com.boostjava2.MonolitikKodlama.services.SatisService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/satis")
@RequiredArgsConstructor
public class SatisController {

    private final SatisService satisService;

    @GetMapping("/savealldemo")
    public ResponseEntity<String> saveAllDemo(){
        satisService.saveAll(new Datas().getSatisList());
        return ResponseEntity.ok("Kayıtlar Eklendi.");
    }
}
