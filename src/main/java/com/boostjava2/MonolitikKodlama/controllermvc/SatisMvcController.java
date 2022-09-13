package com.boostjava2.MonolitikKodlama.controllermvc;

import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import com.boostjava2.MonolitikKodlama.services.MusteriService;
import com.boostjava2.MonolitikKodlama.services.SatisService;
import com.boostjava2.MonolitikKodlama.services.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/WEB/satis")
@RequiredArgsConstructor
public class SatisMvcController {

    private final SatisService satisService;
    private final MusteriService musteriService;
    private final UrunService urunService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("satis");
        modelAndView.addObject("selamarkadasimnasisinnerelerdesin"
                ,satisService.findAllDto());
        modelAndView.addObject("musterilistesi",musteriService.findAll());
        modelAndView.addObject("urunlistesi", urunService.findAll());
        return modelAndView;
    }

    // http://localhost:9090/WEB/satis/save

    /**
     * ÖNEMLİ!!!!!
     * kayıt methodunda tekrardan bir sayfa dönmüyoruz. nedeni zaten bu işlemi yapabilen bir endpoint var
     * oraya yönlendirme yapmak en doğru hareket olacaktır.
     * @param musteriid
     * @param urunid
     * @param adet
     * @param fiyat
     * @return
     */
    @PostMapping("/save")
    public ModelAndView satis(Long musteriid, Long urunid, Integer adet, Double fiyat){
       satisService.save(musteriid,urunid,adet,fiyat);
       return new ModelAndView("redirect:index");
    }
}
