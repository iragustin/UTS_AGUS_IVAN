package com.ivanwijaya.service.framework;

import com.ivanwijaya.entity.Paket;

import java.util.List;
import java.util.Optional;

public interface PaketService {
    List<Paket> getAllPakets();

    Optional<Paket> findById(Long id);

    Optional<Paket> findByEmail(String email);

    Paket save(Paket std);

    void deleteById(Long id);
}
