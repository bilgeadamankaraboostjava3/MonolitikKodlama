package com.boostjava2.MonolitikKodlama.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblurun")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Urun  {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Long id;
    @Column(length = 300,nullable = false)
    String ad;
    String marka;
    String model;
    @Column(nullable = false)
    Double fiyat;
    int stok;
    int state;
    Long createddate;
    Long updateddate;
}
