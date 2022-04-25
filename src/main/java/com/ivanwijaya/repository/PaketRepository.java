package com.ivanwijaya.repository;

import com.ivanwijaya.entity.Paket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaketRepository extends JpaRepository<Paket, Long> {
    Optional<Paket> findByEmail(String email);
}
