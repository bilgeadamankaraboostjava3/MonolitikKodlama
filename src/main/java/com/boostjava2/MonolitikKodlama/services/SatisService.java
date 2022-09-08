package com.boostjava2.MonolitikKodlama.services;

import com.boostjava2.MonolitikKodlama.repository.SatisRepository;
import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import org.springframework.stereotype.Service;


@Service
public class SatisService extends ServiceManager<Satis, Long> {
    private final SatisRepository satisRepository;

    public SatisService(SatisRepository satisRepository) {
        super(satisRepository);
        this.satisRepository = satisRepository;
    }
}
