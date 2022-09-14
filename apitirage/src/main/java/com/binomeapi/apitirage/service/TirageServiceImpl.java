package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.Tirage;
import com.binomeapi.apitirage.repository.TirageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TirageServiceImpl implements TirageService{

    @Autowired
   private final TirageRepository tirageRepository;

    @Override
    public List<Postulant> creer(@RequestBody Tirage tirage, List<Postulant> listAtrier, Long nbre, Long id_Listpost) {
        //création d'une variable random
        Random rand = new Random();

        //declaration de la liste qui contiendra les postulants selectionnés
        List<Postulant> list = new ArrayList<>();

        for (int i = 0; i< nbre; i++)
        {
            Integer idAct = rand.nextInt(listAtrier.size());


            list.add(listAtrier.get(idAct));

            listAtrier.remove(listAtrier.get(idAct));
        }
        return list;
    }

    @Override
    public List<Tirage> lister() {
        return tirageRepository.findAll();
    }

    @Override
    public Tirage ajouter(Tirage tirage) {
        return tirageRepository.save(tirage);
    }

    @Override
    public Tirage trouverTirageParLibelle(String libelle) {
        return tirageRepository.findByLibelle(libelle);
    }

    @Override
    public List<Postulant> creer(Tirage tirage, List<Postulant> post, Long nbre) {
        Random rand = new Random();

        //declaration de la liste qui contiendra les postulants selectionnés
        List<Postulant> list = new ArrayList<>();

        for (int i = 0; i< nbre; i++)
        {
            Integer idAct = rand.nextInt(post.size());

            System.err.println(idAct);

            list.add(post.get(idAct));

            post.remove(post.get(idAct));
        }

        tirageRepository.save(tirage);
        return list;
    }

  @Override
  public String nombre(String libelle) {
    return tirageRepository.nombre(libelle);
  }

  @Override
  public Iterable<Object[]> AfficherTirageParListe(Long id_listPost) {
    return tirageRepository.AfficherTirageParListe(id_listPost);
  }

  @Override
  public Long nbrePostTirer(Long id_tirage) {
    return tirageRepository.nbrePostTirer(id_tirage);
  }



}
