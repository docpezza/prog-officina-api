package com.concessionaria.controller;

import com.concessionaria.entity.Auto;
import com.concessionaria.entity.Veicolo;
import com.concessionaria.service.VeicoloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veicoli")
public class VeicoloController {

    private final VeicoloService service;

    public VeicoloController(VeicoloService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veicolo> getVeicoli() {
        return service.getInventario();
    }

    @GetMapping("/marca/{marca}")
    public List<Veicolo> getVeicoliPerMarca(@PathVariable String marca) {
        return service.cercaPerMarca(marca);
    }

    @GetMapping("/economici")
    public List<Veicolo> getVeicoliEconomici(@RequestParam double budget) {
        return service.trovaVeicoliEconomici(budget);
    }

    @PostMapping
    public String aggiungiVeicolo(@RequestBody AutoRequest request) {
        Auto auto = new Auto(
                request.getMarca(),
                request.getModello(),
                request.getPrezzo(),
                request.getPorte()
        );

        service.aggiungiVeicolo(auto);

        return "Veicolo aggiunto correttamente";
    }
}