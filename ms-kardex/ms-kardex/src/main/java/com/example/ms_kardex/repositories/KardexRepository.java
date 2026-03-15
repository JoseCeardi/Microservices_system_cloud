package com.example.ms_kardex.repositories;

import com.example.ms_kardex.entities.KardexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KardexRepository extends JpaRepository<KardexEntity, Long> {
}