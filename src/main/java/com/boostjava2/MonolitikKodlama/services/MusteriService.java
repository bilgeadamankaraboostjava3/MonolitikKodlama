package com.boostjava2.MonolitikKodlama.services;

import com.boostjava2.MonolitikKodlama.repository.MusteriRepository;
import com.boostjava2.MonolitikKodlama.repository.entity.Musteri;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriService extends ServiceManager<Musteri, Long>{

    private final MusteriRepository musteriRepository;

    /***
     * Spring gerekli sınıfların newsnelerini yaratarak constructor a geçer
     * @param musteriRepository
     */
    public MusteriService(MusteriRepository musteriRepository) {
        /**
         * super miras alınan sınıfın constructor'ını çağırır.
         * super den önce kod yazılamaz.
         */
        super(musteriRepository);
        this.musteriRepository = musteriRepository;
    }

    public List<Musteri> findAllByAdres(String adres){
        return musteriRepository.findAllByAdres(adres);
    }

    public List<Musteri> findAllByAdLike(String ad){
        return musteriRepository.findAllByAdLike(ad);
    }

    public List<Musteri> findByAdStartsWithAndAdresStartsWith(String ad, String adres){
        return musteriRepository.findByAdStartsWithAndAdresStartsWith(ad, adres);
    }

    public List<Musteri> findAllByCreateddateGreaterThan(Long createddate){
        return musteriRepository.findAllByCreateddateGreaterThan(createddate);
    }

    public Optional<Musteri> findByAd(String ad){
        return musteriRepository.findTopOptionalByAd(ad);
    }
    public  Optional<Musteri> findTopOptionalByAdOOrderByIdDesc(String ad){
        return musteriRepository.findTopOptionalByAdOrderByIdDesc(ad);
    }
}
