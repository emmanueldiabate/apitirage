package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.repository.PostulantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PostulantServiceImpl implements PostulantService{

    @Autowired
    PostulantRepository postulantRepository;

    @PostMapping("/ajouter")
    @Override
    public Postulant Ajout(Postulant postulant) {
        return postulantRepository.save(postulant);
    }

    @Override
    public List<Postulant> lister() {
        return postulantRepository.findAll();
    }

    @Override
    public List<Postulant> enregistrer(List<Postulant> postulantList) {
        return postulantRepository.saveAll(postulantList);
    }

    @Override
    public List<Postulant> Trouverid_Liste_postulant(Long id_listPost) {
        return postulantRepository.FINDIDPOSTLIST(id_listPost);
    }

    @Override
    public List<Postulant> postulantParListe(Listpost postulant) {
        return postulantRepository.findByListePostulant(postulant);
    }
}
