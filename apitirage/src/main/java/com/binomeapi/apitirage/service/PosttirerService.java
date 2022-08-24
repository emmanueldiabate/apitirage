package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Posttirer;

import java.util.List;

public interface PosttirerService {

    List<Posttirer> lister();

    Posttirer Modifier(Posttirer posttirer, Long id);

    Posttirer ajouter(Posttirer posttirer);

    int  creer(Long id_post,  String email, String nom, String numero, String prenom, Long id_tirage);
}
