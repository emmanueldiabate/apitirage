package com.binomeapi.apitirage.controller;

import com.binomeapi.apitirage.modele.Listpost;

import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.Tirage;
import com.binomeapi.apitirage.service.ListpostService;
import com.binomeapi.apitirage.service.PosttirerService;
import com.binomeapi.apitirage.service.PostulantService;
import com.binomeapi.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Tirage")
@AllArgsConstructor
public class TirageController {

    @Autowired
    private final TirageService tirageService;
    private final ListpostService listpostService;
    private final PostulantService postulantService;
    private  final PosttirerService posttirerService;

    @PostMapping("/createTirage/{libelle}/{nbre}")
    public String create(@RequestBody Tirage tirage, @PathVariable String libelle, @PathVariable Long nbre){

        tirage.setDate(new Date());
        Listpost listpost = listpostService.trouverListeParLibelle(libelle);
        //retourne tous les postulants d'une liste donnée
        Long id_Liste_postulant = listpost.getId_listPost(); //identifiant de la liste entrée par l'user
        List<Postulant> postulantList = postulantService.postulantParListe(listpost);
        System.out.println(postulantList);

        List<Postulant> ListePostulants = tirageService.creer(tirageService.ajouter(tirage), postulantList, nbre, id_Liste_postulant);//recuperation des id des postulant trié
        Long id_Tirage = tirageService.trouverTirageParLibelle(tirage.getLibelle()).getId_tirage();

        //for (Postulant p : ListePostulants){

            //Posttirer posttirer=new Posttirer(null, tirageService.trouverTirageParLibelle(tirage.getLibelle()));
           // Posttirer pos=new Posttirer(id_postTirer, tirageService.trouverTirageParLibelle(tirage.getLibelle()));//tirageService.trouverTirageParLibelle(tirage.getLibelle()));
           // posttirerService.//ajouter(pos);
            //postulantTrieService.creer(p.getId_postulant(),p.getNom_postulant(),p.getPrenom_postulant(), p.getNumero_postulant(),p.getMail_postulant(), id_Tirage);
      //  }

        return "succès";
    }
}
