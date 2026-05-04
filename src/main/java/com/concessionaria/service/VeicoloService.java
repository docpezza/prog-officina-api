package com.concessionaria.service;

import com.concessionaria.entity.Veicolo;
import com.concessionaria.repository.VeicoloRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VeicoloService {

    private final VeicoloRepository repository;
    private final List<Veicolo> inventario = new ArrayList<>();

    public VeicoloService(VeicoloRepository repository) {
        this.repository = repository;
        this.inventario.addAll(repository.carica());
    }

    public void aggiungiVeicolo(Veicolo veicolo) {
        inventario.add(veicolo);
        repository.salva(veicolo);
    }

    public List<Veicolo> getInventario() {
        return inventario;
    }

    public List<Veicolo> cercaPerMarca(String marca) {
        return inventario.stream()
                .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                .toList();
    }

    public List<Veicolo> trovaVeicoliEconomici(double budget) {
        return inventario.stream()
                .filter(v -> v.getPrezzo() <= budget)
                .toList();
    }

    public List<Veicolo> trovaVeicoliPerPrezzo(double prezzo) {
        return inventario.stream()
                .filter(v -> v.getPrezzo() == prezzo)
                .toList();
    }
}