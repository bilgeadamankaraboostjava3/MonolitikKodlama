package com.boostjava2.MonolitikKodlama;

import com.boostjava2.MonolitikKodlama.services.MusteriService;
import com.boostjava2.MonolitikKodlama.services.SatisService;
import com.boostjava2.MonolitikKodlama.services.UrunService;
import com.boostjava2.MonolitikKodlama.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class MonolitikKodlamaApplication {

	private final SatisService satisService;
	private final UrunService urunService;
	private final MusteriService musteriService;
	@PostConstruct
	private void implData(){
		musteriService.saveAll(new Datas().getMusteriList());
		urunService.saveAll(new Datas().getUrunList());
		satisService.saveAll(new Datas().getSatisList());
	}
	public static void main(String[] args) {
		SpringApplication.run(MonolitikKodlamaApplication.class, args);
	}

}
