package com.boostjava2.MonolitikKodlama.controller;

import com.boostjava2.MonolitikKodlama.dto.request.FindByIdRequestDto;
import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import com.boostjava2.MonolitikKodlama.services.SatisService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getall")
    public ResponseEntity<List<Satis>> findAll(){
        return ResponseEntity.ok(satisService.findAll());
    }

    @PostMapping("/findbyid")
    public ResponseEntity<Satis> findById(FindByIdRequestDto dto){
        Optional<Satis> satis = satisService.findById(dto);
        if(satis.isPresent()){
            return ResponseEntity.ok(satis.get());
        }
        return ResponseEntity.ok(new Satis());
    }

}
