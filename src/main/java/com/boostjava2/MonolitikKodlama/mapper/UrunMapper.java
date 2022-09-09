package com.boostjava2.MonolitikKodlama.mapper;

import com.boostjava2.MonolitikKodlama.dto.request.UrunSaveRequestDto;
import com.boostjava2.MonolitikKodlama.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *
 * !!ÖNEMLİ!!
 * Bir pojo nesnesinden diğer bir pojo nesnesine dönüşüm yaparken illaki uyuşmayan
 * alanlar olabilir, bu durumda hata alırsınız. çünkü karşılığı olamyan alanlar için
 * hata döner. Bu nedenle sorun yaşamamak için ReportingPolicy.IGNORE eklememiz gerekiyor.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UrunMapper {
    UrunMapper INSTANCE = Mappers.getMapper( UrunMapper.class );
    /**
     * UrunSaveRequestDto yu Urun e dönüştürmek istiyoruz.
     * Alınacak bilgi: Dto
     * Çıktılanacak bilgi: Urun
     */
    Urun toUrun(UrunSaveRequestDto dto);
    UrunSaveRequestDto fromUrun(Urun urun);

}
