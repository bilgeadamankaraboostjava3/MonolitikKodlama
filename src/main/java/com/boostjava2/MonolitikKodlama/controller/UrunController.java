package com.boostjava2.MonolitikKodlama.controller;

import com.boostjava2.MonolitikKodlama.repository.entity.Urun;
import com.boostjava2.MonolitikKodlama.services.UrunService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urun")
@RequiredArgsConstructor
public class UrunController {

    private final UrunService urunService;

    @GetMapping("/savealldemo")
    public ResponseEntity<String> saveAllDemo(){
        urunService.saveAll(new Datas().getUrunList());
        return ResponseEntity.ok("Kayıt başarılı");
    }

}
