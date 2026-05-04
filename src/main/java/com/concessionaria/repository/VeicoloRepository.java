package com.concessionaria.repository;

import com.concessionaria.entity.Veicolo;
import java.util.List;

public interface VeicoloRepository {
    void salva(Veicolo veicolo);
    List<Veicolo> carica();
}