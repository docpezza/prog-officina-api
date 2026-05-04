package com.concessionaria.repository;

import com.concessionaria.entity.Auto;
import com.concessionaria.entity.Moto;
import com.concessionaria.entity.Veicolo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FileVeicoloRepository implements VeicoloRepository {

    private static final String FILE_NAME = "db_veicoli.txt";

    @Override
    public void salva(Veicolo veicolo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            String tipo = (veicolo instanceof Auto) ? "AUTO" : "MOTO";

            writer.write(tipo + "," +
                    veicolo.getModello() + "," +
                    veicolo.getMarca() + "," +
                    veicolo.getPrezzo());

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    @Override
    public List<Veicolo> carica() {
        List<Veicolo> listaCaricata = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String riga;

            while ((riga = reader.readLine()) != null) {
                String[] pezzi = riga.split(",");

                if (pezzi.length == 4) {
                    String tipo = pezzi[0];
                    String modello = pezzi[1];
                    String marca = pezzi[2];
                    double prezzo = Double.parseDouble(pezzi[3]);

                    if (tipo.equals("AUTO")) {
                        listaCaricata.add(new Auto(modello, marca, prezzo, 4));
                    } else if (tipo.equals("MOTO")) {
                        listaCaricata.add(new Moto(modello, marca, prezzo, false));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Errore durante il caricamento: " + e.getMessage());
        }

        return listaCaricata;
    }
}