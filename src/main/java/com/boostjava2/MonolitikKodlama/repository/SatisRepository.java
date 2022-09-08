package com.boostjava2.MonolitikKodlama.repository;

import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisRepository extends JpaRepository<Satis,Long> {

}
