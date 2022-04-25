package com.ivanwijaya.service.implementation;

import com.ivanwijaya.entity.Paket;
import com.ivanwijaya.repository.PaketRepository;
import com.ivanwijaya.service.framework.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaketServiceImpl implements PaketService {
    private final PaketRepository paketRepository;

    @Autowired
    public PaketServiceImpl(PaketRepository paketRepository){
        this.paketRepository = paketRepository;
    }

    @Override
    public Optional<Paket> findByEmail(String email) {

        return paketRepository.findByEmail(email);
    }

    @Override
    public List<Paket> getAllPakets() {
        return paketRepository.findAll();
    }

    @Override
    public Optional<Paket> findById(Long id) {

        return paketRepository.findById(id);
    }



    @Override
    public Paket save(Paket std) {

        return paketRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {

        paketRepository.deleteById(id);
    }
}
