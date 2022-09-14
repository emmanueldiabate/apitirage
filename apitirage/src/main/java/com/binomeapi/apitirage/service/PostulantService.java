package com.binomeapi.apitirage.service;


import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostulantService {

    Postulant creer(Postulant postulant);

    List<Postulant> lister();


    List<Postulant> enregistrer(List<Postulant> postulantList);

    //Methodes pour le tirage

    List<Postulant> Trouverid_Liste_postulant(Long id_Liste_postulant);

    List<Postulant> postulantParListe(Listpost postulant);

    Postulant modifier(Long id_post, Postulant postulant);

    String supprimer(Long id_post);



}
