package com.boostjava2.MonolitikKodlama.repository;

import com.boostjava2.MonolitikKodlama.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Long> {

    /**
     * ** Adresi belirtilen müşterileri getirir. equals şeklinde çalışır **
     * find ile başlanacak,
     * By ile devam edecek
     * Sonrasında ise arama yapılacak alanın adı yazılacak
     * @param adres
     * @return
     */
    List<Musteri> findAllByAdres(String adres);

    /**
     * ** SQL deki like ile aynı işlevi görür. **
     * -- ad kısmına girilen sorguyu çalıştırır. ÖRN: %e% -> e harfi içerenleri getirir., 'a%' -> a ile başlayanları getirir.
     * @param ad
     * @return
     */
    List<Musteri> findAllByAdLike(String ad);

    /**
     * ** Hem ad hemde adres ile sorgulama yapalım.
     */
    List<Musteri> findByAdStartsWithAndAdresStartsWith(String ad, String adres);

    /**
     * ** Bugün kayıt olan kaç kişi var? **
     */

    List<Musteri> findAllByCreateddateGreaterThan(Long createddate);

    /**
     * Optional -> null değer döndürmesini engeller.
     */
    // XXXX Musteri findByAd(String ad);
    Optional<Musteri> findTopOptionalByAd(String ad);
    Optional<List<Musteri>> findOptionalByAdres(String adres);
    Optional<Musteri> findTopOptionalByAdOrderByIdDesc(String ad);

    /**
     * iki tarih arasındaki kayıtları getir.
     */
    List<Musteri> findAllByCreateddateBetween(Long start, Long end);
    List<Musteri> findAllByAdresAndCreateddateBetween(String adres,Long start, Long end);

    @Query("select m from Musteri m where m.email = ?1")
    Musteri findByEmailAdres(String emailAdres);

    @Query(value = "SELECT * FROM Musteri WHERE email = ?1 and ad like ?2", nativeQuery = true)
    Musteri findByEmailAddress(String emailAddress, String ad);

    @Query("select u from Musteri u where u.ad = :ad or u.soyad = :soyad")
    Musteri findByAdOrSoyad(@Param("ad") String musteriadi,
                            @Param("soyad") String musterisoyadi);

    Musteri findByEmail(String email);
}
