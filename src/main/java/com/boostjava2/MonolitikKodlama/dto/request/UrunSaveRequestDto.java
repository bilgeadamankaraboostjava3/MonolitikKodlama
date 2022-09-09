package com.boostjava2.MonolitikKodlama.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UrunSaveRequestDto {
    String ad;
    String marka;
    String model;
    Double fiyat;
}
