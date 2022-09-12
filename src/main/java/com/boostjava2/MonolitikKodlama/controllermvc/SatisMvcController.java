package com.boostjava2.MonolitikKodlama.controllermvc;

import com.boostjava2.MonolitikKodlama.services.SatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/WEB/satis")
@RequiredArgsConstructor
public class SatisMvcController {

    private final SatisService satisService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("satis");
        modelAndView.addObject("satislistesi"
                ,satisService.findAllDto());
        return modelAndView;
    }

}
