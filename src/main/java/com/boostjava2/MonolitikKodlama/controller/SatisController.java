package com.boostjava2.MonolitikKodlama.controller;

import com.boostjava2.MonolitikKodlama.dto.request.FindByIdRequestDto;
import com.boostjava2.MonolitikKodlama.dto.response.GetAllSatisResponseDto;
import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import com.boostjava2.MonolitikKodlama.services.SatisService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.boostjava2.MonolitikKodlama.constants.Urls.*;
import java.util.List;
import java.util.Optional;

/**
 * RestAPI
 * -- Kullanıcıdan tüm HTML methodlarında istek alıp yine kullanıyıya
 *    response olarak bir Entity dönebildiğimiz yapılandırma şeklidir.
 * -- 3. Parti uygulamaların birbirleriyle haberleşmesi için kullanılır.
 * -- Microservis yapısında anahtar rol oynar ve microservislerin aralarında
 *    haberleşmesini sağlar.
 */
@RestController
@RequestMapping(VERSION+API + SATIS)
@RequiredArgsConstructor
public class SatisController {

    private final SatisService satisService;

    /**
     * Action -> Method kendisi
     * localhost:9090/satis/savealldemo
     * GET
     * POST
     * PUT
     * DELETE
     *
     * @return
     */
    @GetMapping(SAVEALL)
    public ResponseEntity<String> saveAllDemo(){
        satisService.saveAll(new Datas().getSatisList());
        return ResponseEntity.ok("Kayıtlar Eklendi.");
    }

    @GetMapping(GETALLBYMUSTERIADI)
    public ResponseEntity<List<GetAllSatisResponseDto>> findAllByMusteriAdGet(String musteriadi){
        System.out.println("Get Mothodu Çağrıldı.");
        return ResponseEntity.ok(satisService.findAllDto(musteriadi));
    }

    @PostMapping(GETALLBYMUSTERIADI)
    public ResponseEntity<List<GetAllSatisResponseDto>> findAllByMusteriAdPost(String musteriadi){
        System.out.println("Post Mothodu Çağrıldı.");
        return ResponseEntity.ok(satisService.findAllDto(musteriadi));
    }
    /**
     * localhost:9090/satis/getall
     * @return
     */
    @GetMapping(FINDALL)
    public ResponseEntity<List<GetAllSatisResponseDto>> findAll(String id){
        System.out.println("gelen id......: " + id);
        return ResponseEntity.ok(satisService.findAllDto());
    }

    @PostMapping(FINDBYID)
    public ResponseEntity<Satis> findById(FindByIdRequestDto dto){
        Optional<Satis> satis = satisService.findById(dto);
        if(satis.isPresent()){
            return ResponseEntity.ok(satis.get());
        }
        return ResponseEntity.ok(new Satis());
    }

    @GetMapping("/message")
    public String getMessage(){
        return "Merhaba";
    }

}
