package com.boostjava2.MonolitikKodlama.controller;

import com.boostjava2.MonolitikKodlama.dto.request.UrunSaveRequestDto;
import com.boostjava2.MonolitikKodlama.repository.entity.Urun;
import com.boostjava2.MonolitikKodlama.services.UrunService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.boostjava2.MonolitikKodlama.constants.Urls.*;
@RestController
@RequestMapping(VERSION+API + URUN)
@RequiredArgsConstructor
public class UrunController {

    private final UrunService urunService;

    @GetMapping(SAVEALL)
    public ResponseEntity<String> saveAllDemo(){
        urunService.saveAll(new Datas().getUrunList());
        return ResponseEntity.ok("Kayıt başarılı");
    }

    @PostMapping(SAVE)
    public ResponseEntity<Urun> save(Urun urun){
        return ResponseEntity.ok(urunService.save(urun));
    }

    @PostMapping(SAVEPARAM)
    public ResponseEntity<Urun> saveParameter(String ad,String marka,
                                              String model,Double fiyat){
        Urun urun = Urun.builder()
                .fiyat(fiyat)
                .marka(marka)
                .model(model)
                .ad(ad).build();
        return ResponseEntity.ok(urunService.save(urun));
    }

    @PostMapping(SAVEPARAMDTO)
    public ResponseEntity<Urun> saveParamDto(UrunSaveRequestDto dto){
        return ResponseEntity.ok(urunService.saveMapper(dto));
    }

}
