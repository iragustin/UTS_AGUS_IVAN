package com.ivanwijaya.controller;

import com.ivanwijaya.entity.Paket;
import com.ivanwijaya.service.framework.PaketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PaketWebController {
    private PaketService paketService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("paket", paketService.getAllPakets());
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model){
        model.addAttribute("paket", new Paket());
        return "formpaket";
    }

    @PostMapping(value = "/create")
    public String tambahPaket(Model model, Paket paket){
        model.addAttribute("paket", paketService.save(paket));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("paket", paketService.findById(id));
        return "formpaket";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id){
        paketService.deleteById(id);
        return "redirect:/";
    }
}
