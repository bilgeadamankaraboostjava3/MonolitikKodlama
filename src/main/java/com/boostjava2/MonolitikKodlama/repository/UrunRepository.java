package com.boostjava2.MonolitikKodlama.repository;

import com.boostjava2.MonolitikKodlama.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository<Urun,Long> {

}
