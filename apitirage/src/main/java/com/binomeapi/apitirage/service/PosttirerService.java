package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Posttirer;

import java.util.List;

public interface PosttirerService {
   //je suis null
    List<Posttirer> lister();

    Posttirer ajouter(Posttirer posttirer);

    //
    Posttirer Save(Posttirer posttirer);

}
