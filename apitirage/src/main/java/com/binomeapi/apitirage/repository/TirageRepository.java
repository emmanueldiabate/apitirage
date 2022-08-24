package com.binomeapi.apitirage.repository;

import com.binomeapi.apitirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepository extends JpaRepository<Tirage, Long> {

    Tirage findByLibelle(String libelle);
}
