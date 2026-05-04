package com.concessionaria.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Moto extends Veicolo {
    private boolean haSidecar;

    public Moto(String modello, String marca, double prezzo, boolean haSidecar) {
        super(marca, modello, prezzo, 0); // Moto non ha porte
        this.haSidecar = haSidecar;
    }
    @Override
    public void stampaScheda() {
        System.out.println("Moto" + marca + " " + modello + "- Prezzo: " + prezzo + "€" + "Sidecar: " + (haSidecar ? "Sì" : "No"));
    }
}
