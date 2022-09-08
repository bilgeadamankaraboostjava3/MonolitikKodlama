package com.boostjava2.MonolitikKodlama.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblmusteri")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Musteri {

    @Id
    @SequenceGenerator(name = "sq_tblmusteri_id",
            sequenceName = "sq_tblmusteri_id", allocationSize = 5, initialValue = 100)
    @GeneratedValue(generator = "sq_tblmusteri_id")
    Long id;
    /**
     * ORM -> Id
     * musteriRepository.save(musteri);
     * 1- durum eğer id null ise ya da 0 ise insert yapar
     * 2- durum eğer id null değilse ya da 0 dan farklı ise update yapar
     */
    String ad;
    String soyad;
    String adres;
    String telefon;
    String email;
    /**
     * 0-> pasif
     * 1-> aktif
     * 2-> silinmis
     * 3-> bloke
     */
    int state;
    Long createddate;
    /**
     * 07/09/2022 15:12:01.224
     * 1662552615000
     */
    Long updateddate;
}
