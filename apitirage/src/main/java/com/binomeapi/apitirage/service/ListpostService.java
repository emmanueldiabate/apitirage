package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Listpost;

import java.util.List;

public interface ListpostService {
    Listpost creer(Listpost listpost);

    List<Listpost> lister();

    Listpost trouverListeParLibelle(String libelle);

    Iterable<Object[]> trverIdList(Long id_list_post);

    //String nombre(String libelle);
}
