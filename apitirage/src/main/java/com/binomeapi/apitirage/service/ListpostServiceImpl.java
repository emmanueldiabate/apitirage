package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.repository.ListpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListpostServiceImpl implements ListpostService{

    @Autowired
    ListpostRepository listpostRepository;

    @Override
    public Listpost creer(Listpost listpost) {
        return listpostRepository.save(listpost);
    }

    @Override
    public List<Listpost> lister() {
        return listpostRepository.findAll();
    }

    @Override
    public Listpost trouverListeParLibelle(String libelle) {
        return listpostRepository.findByLibelle(libelle);
    }

  @Override
  public Iterable<Object[]> trverIdList(Long id_list_post) {
    return listpostRepository.trverIdList(id_list_post);
  }

  /*@Override
  public String nombre(String libelle) {
    return listpostRepository.nombre(libelle);
  }*/
}
