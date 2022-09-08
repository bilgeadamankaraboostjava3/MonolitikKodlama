package com.boostjava2.MonolitikKodlama.services;

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

}
