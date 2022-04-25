package com.ivanwijaya.controller;

import com.ivanwijaya.entity.Paket;
import com.ivanwijaya.exception.PaketNotFoundException;
import com.ivanwijaya.service.framework.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/pakets")
public class PaketController {
    private final PaketService paketservice;

    @Autowired
    public PaketController(PaketService paketservice) {
        this.paketservice = paketservice;
    }

    @GetMapping
    public List<Paket> getAllPakets() {
        return paketservice.getAllPakets();
    }

    @GetMapping(value = "/{id}")
    public Paket getStudentById(@PathVariable("id") @Min(1) Long id) {
        Paket std = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Paket addPaket(@Valid @RequestBody Paket std) {
        return paketservice.save(std);
    }

    @PutMapping(value = "/{id}")
    public Paket updatePaket(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Paket newStd) {
        Paket paket = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        paket.setFirstName(newStd.getFirstName());
        paket.setLastName(newStd.getLastName());
        paket.setEmail(newStd.getEmail());
        paket.setPhoneNumber(newStd.getPhoneNumber());
        return paketservice.save(paket);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Paket std = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        paketservice.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}
