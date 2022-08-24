package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.Tirage;

import java.util.List;

public interface TirageService {

    List<Tirage> lister();

    Tirage ajouter(Tirage tirage);

    //   Iterable<Object[]> tirageAleatoire(Long id);


    //Methodes pour le tirage
    List<Postulant> creer(Tirage tirage, List<Postulant> listAtrier, Long nbre, Long id_listPost);

    Tirage trouverTirageParLibelle(String libelle);

}
