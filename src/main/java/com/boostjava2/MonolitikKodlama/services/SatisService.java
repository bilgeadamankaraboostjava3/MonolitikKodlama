package com.boostjava2.MonolitikKodlama.services;

import com.boostjava2.MonolitikKodlama.dto.request.FindByIdRequestDto;
import com.boostjava2.MonolitikKodlama.dto.response.GetAllSatisResponseDto;
import com.boostjava2.MonolitikKodlama.repository.SatisRepository;
import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SatisService extends ServiceManager<Satis, Long> {
    private final SatisRepository satisRepository;

    public SatisService(SatisRepository satisRepository) {
        super(satisRepository);
        this.satisRepository = satisRepository;
    }

    public Optional<Satis> findById(FindByIdRequestDto dto){
        if(dto.getId()!=null){
            return satisRepository.findById(dto.getId());
        }
        return Optional.empty();
    }

    public List<GetAllSatisResponseDto> findAllDto(){

    }

}
