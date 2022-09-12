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

    /**
     * OverLoading işlemi yapılmıştır. Aynı isimde farklı parametrelerde metotlar oluşturulmuştur.
     * @param dto
     * @return
     */
    public Urun save(UrunSaveRequestDto dto){
        return urunRepository.save(UrunMapper.INSTANCE.toUrun(dto));
    }

    public Urun saveMapper(UrunSaveRequestDto dto){
        Urun urun = UrunMapper.INSTANCE.toUrun(dto);
        urun.setCreateddate(System.currentTimeMillis());
        return urunRepository.save(urun);
    }
}
