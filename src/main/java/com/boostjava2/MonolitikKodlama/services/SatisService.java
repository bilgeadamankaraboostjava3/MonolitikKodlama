package com.boostjava2.MonolitikKodlama.services;

import com.boostjava2.MonolitikKodlama.dto.request.FindByIdRequestDto;
import com.boostjava2.MonolitikKodlama.dto.response.GetAllSatisResponseDto;
import com.boostjava2.MonolitikKodlama.repository.MusteriRepository;
import com.boostjava2.MonolitikKodlama.repository.SatisRepository;
import com.boostjava2.MonolitikKodlama.repository.UrunRepository;
import com.boostjava2.MonolitikKodlama.repository.entity.Musteri;
import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import com.boostjava2.MonolitikKodlama.repository.entity.Urun;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SatisService extends ServiceManager<Satis, Long> {
    private final SatisRepository satisRepository;
    //@Autowired
   // private MusteriRepository musteriRepository;
   // @Autowired
   // private UrunRepository urunRepository;
    private final MusteriRepository musteriRepository;
    private final UrunRepository urunRepository;
    public SatisService(SatisRepository satisRepository,
                        MusteriRepository musteriRepository,
                        UrunRepository urunRepository) {
        super(satisRepository);
        this.satisRepository = satisRepository;
        this.urunRepository = urunRepository;
        this.musteriRepository = musteriRepository;
    }

    public Optional<Satis> findById(FindByIdRequestDto dto){
        if(dto.getId()!=null){
            return satisRepository.findById(dto.getId());
        }
        return Optional.empty();
    }

    public List<GetAllSatisResponseDto> findAllDto(String musteriadi){
        return findAllDto().stream().filter(x-> x.getMusteriadi().contains(musteriadi)).collect(Collectors.toList());
    }

    public List<GetAllSatisResponseDto> findAllDto(){
        /**
         * Satis tablosundaki tüm kayıtları alıyoruz.
         */
        List<Satis> satisList = satisRepository.findAll();
        /**
         * Satış tablosundan alacağımız datayı düzenleyerek bir DTO objesi olarak
         * dönmek istiyoruyz. bu nedenle öncelike boş bir DTO listesi oluşturuyoruz.
         */
        List<GetAllSatisResponseDto> responseDtoList = new ArrayList<>();
        /**
         * Satış listesini dönüyoruz hher bir kayıt için arama yaplılacak ve uygun kayıtlar
         * DTO listesine eklenicek.
         */
        satisList.forEach(x->{
            /**
             * Her bir satıştaki müşteri id için müşteriyi VT nından soorguluyoruz.
             */
            Optional<Musteri> musteri = musteriRepository.findById(x.getMusteriid());
            /**
             * Her bir satıştaki ürün id için ürünü VT nından soorguluyoruz.
             */
            Optional<Urun> urun = urunRepository.findById(x.getUrunid());
            /**
             * Müşteri ve Urun gerçekten VT nında var mıdır? kontrol ediyoruz.
             */

            if(musteri.isPresent() && urun.isPresent()){
                /**
                 * Olluşturulan DTO DTOLİST içine ekleniyor.
                 */
                responseDtoList.add(GetAllSatisResponseDto.builder()
                        .id(x.getId())
                        .adet(x.getAdet())
                        .fiyat(x.getFiyat())
                        .toplamfiyat(x.getFiyat()*x.getAdet())
                        .createddate(
                                Instant.ofEpochMilli(x.getCreateddate())
                                        .atZone(java.time.ZoneId.systemDefault())
                                        .toLocalDate()
                        )
                                .urunadi(urun.get().getAd()+" - marka: "+ urun.get().getMarka()+"model: "+urun.get().getModel())
                                .musteriadi(musteri.get().getAd())
                                .musteriid(musteri.get().getId())
                                .urunid(urun.get().getId())
                        .build());
            }else{
                /**
                 * Müşteri veya ürün bulunamadıysa hata mesajı döndürüyoruz.
                 */
                System.out.println("Müşteri veya ürün bulunamadı...: [Satis Id] "+ x.getId());
            }

        });

        return responseDtoList;
    }

    public void save(Long musteriid,Long urunid,Integer adet,Double fiyat){
        satisRepository.save(Satis.builder()
                .musteriid(musteriid)
                .urunid(urunid)
                .adet(adet)
                .fiyat(fiyat)
                        .createddate(System.currentTimeMillis())
                .build());
    }

}
