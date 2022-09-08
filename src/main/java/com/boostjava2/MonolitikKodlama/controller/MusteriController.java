package com.boostjava2.MonolitikKodlama.controller;

import com.boostjava2.MonolitikKodlama.repository.entity.Musteri;
import com.boostjava2.MonolitikKodlama.services.MusteriService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musteri")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;

    /**
     * localhost:9090/musteri/save
     * @return
     */
    @GetMapping("/saveall")
    public ResponseEntity<Void> saveAll(){
        try{
            musteriService.saveAll(new Datas().getMusteriList());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Musteri>> findAll(){
        return ResponseEntity.ok(musteriService.findAll());
    }

    @GetMapping("/getallbyadres")
    public ResponseEntity<List<Musteri>> findAllByAdres(){
        String adres = "İstanbul";
        return ResponseEntity.ok(musteriService.findAllByAdres(adres));
    }

    @GetMapping("/getallbyadlike")
    public ResponseEntity<List<Musteri>> findAllByAdLike(){
        String ad = "%e%";
        return ResponseEntity.ok(musteriService.findAllByAdLike(ad));
    }

    @GetMapping("/getallbyadandadres")
    public ResponseEntity<List<Musteri>> findByAdStartsWithAndAdresStartsWith(){
        String ad = "A";
        String adres = "A";
        return ResponseEntity.ok(musteriService.findByAdStartsWithAndAdresStartsWith(ad, adres));
    }

    @GetMapping("/getallbycreateddate")
    public ResponseEntity<List<Musteri>> findAllByCreateddateGreaterThan(){
        Long createddate = 1662498000000L; // 08.09.2022 00:00:00

        return ResponseEntity.ok(musteriService.findAllByCreateddateGreaterThan(createddate));
    }

    @GetMapping("/getallbyad")
    public ResponseEntity<Object> findByAd(){
        String ad = "Ali";
        Optional<Musteri> musteri = musteriService.findByAd(ad);
        if(musteri.isPresent())
            return ResponseEntity.ok(musteri.get());

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getallbyaddesc")
    public ResponseEntity<Object> findByAdDesc(){
        String ad = "Ali";
        Optional<Musteri> musteri = musteriService.findTopOptionalByAdOOrderByIdDesc(ad);
        if(musteri.isPresent())
            return ResponseEntity.ok(musteri.get());

        return ResponseEntity.badRequest().build();
    }

    Musteri musteri;
    Optional<Musteri> musteriOptional;
    private void OptionalD(){
        if(musteri !=null)
            musteri.getAd().equals("");

        if(musteriOptional.isPresent())
            musteriOptional.get().getAd().equals("");
    }

}
