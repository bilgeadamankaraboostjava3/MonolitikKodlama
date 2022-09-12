package com.boostjava2.MonolitikKodlama.controllermvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/WEB/musteri")
public class MusteriMvcController {
    /**
     * http://localhost:9090/WEB/musteri/index
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("musteri");
        String manset = "Thymeleaf ile MVC";
        List<String> isimlistesi =
                Arrays.asList("Ahmet","Mehmet","Ali","Veli","Ayşe","Fatma","Zeynep");
        modelAndView.addObject("isimler",isimlistesi);
        modelAndView
                .addObject("manset",manset);
        return modelAndView;

    }

}
