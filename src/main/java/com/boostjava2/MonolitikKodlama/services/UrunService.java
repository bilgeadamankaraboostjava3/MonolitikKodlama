package com.boostjava2.MonolitikKodlama.services;

import com.boostjava2.MonolitikKodlama.dto.request.UrunSaveRequestDto;
import com.boostjava2.MonolitikKodlama.mapper.UrunMapper;
import com.boostjava2.MonolitikKodlama.repository.UrunRepository;
import com.boostjava2.MonolitikKodlama.repository.entity.Urun;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun, Long> {
    private final UrunRepository urunRepository;


    public UrunService(UrunRepository urunRepository) {
        super(urunRepository);
        this.urunRepository = urunRepository;
    }

    public Urun save(UrunSaveRequestDto dto){
        Urun urun = Urun.builder()
                .fiyat(dto.getFiyat())
                .marka(dto.getMarka())
                .model(dto.getModel())
                .ad(dto.getAd()).build();
        return urunRepository.save(urun);
    }

    public Urun saveMapper(UrunSaveRequestDto dto){
        Urun urun = UrunMapper.INSTANCE.toUrun(dto);
        urun.setCreateddate(System.currentTimeMillis());
        return urunRepository.save(urun);
    }
}
