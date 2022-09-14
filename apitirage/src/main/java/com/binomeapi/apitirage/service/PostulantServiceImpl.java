package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.repository.PostulantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    public Postulant modifier(Long id_post, Postulant postulant) {
        return postulantRepository.findById(id_post)
                .map(p-> {
                    p.setMail(postulant.getMail());
                    p.setNom(postulant.getNom());
                    p.setNumero(postulant.getNumero());
                    p.setPrenom(postulant.getPrenom());
                    p.setListpost(postulant.getListpost());
                    return postulantRepository.save(postulant);
                }).orElseThrow(() -> new RuntimeException("Postulant introuvable !"));
    }

    @Override
    public String supprimer(Long id_post) {
          postulantRepository.deleteById(id_post);
          return "Postulant supprimer avec succes !";
    }
}
