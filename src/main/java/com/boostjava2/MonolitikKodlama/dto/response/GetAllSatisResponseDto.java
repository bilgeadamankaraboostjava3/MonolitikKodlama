package com.boostjava2.MonolitikKodlama.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetAllSatisResponseDto {
    private Long id;
    private String musteriadi;
    private String urunadi;
    private int adet;
    private Double fiyat;
    private Double toplamfiyat;
    private LocalDate createddate;

}
