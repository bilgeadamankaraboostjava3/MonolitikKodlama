package com.boostjava2.MonolitikKodlama.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblsatis")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Long musteriid;
    Long urunid;
    int adet;
    Double fiyat;
    int state;
    Long createddate;
    Long updateddate;
}
