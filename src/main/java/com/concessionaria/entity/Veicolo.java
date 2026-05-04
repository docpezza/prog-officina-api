package com.concessionaria.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Veicolo {
    protected String marca;
    protected String modello;
    protected double prezzo;
    protected double porte;
    public void stampaScheda() {
        System.out.println("Modello: " + this.modello);
        System.out.println("Marca: " + this.marca);
        System.out.println("Prezzo:" + this.prezzo);
        System.out.println("Porte:" + this.porte);
    }

}
