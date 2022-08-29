package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.repository.PostulantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@AllArgsConstructor

public class PostulantServiceImpl implements PostulantService{

    @Autowired
    private  final PostulantRepository postulantRepository;

    @Override
    public Postulant creer(Postulant postulant) {
        return  this.postulantRepository.save(postulant);
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
        return postulantRepository.findByIdPost(id_listPost);
    }

    @Override
    public List<Postulant> postulantParListe(Listpost listpost) {

        return postulantRepository.findByListpost(listpost);
    }
}
