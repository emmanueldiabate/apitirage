package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Listpost;

import java.util.List;

public interface ListpostService {

    Listpost importer(Listpost listpost);

    List<Listpost> lire();

}
