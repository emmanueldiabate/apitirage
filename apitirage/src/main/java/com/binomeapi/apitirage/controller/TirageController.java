package com.binomeapi.apitirage.controller;

import com.binomeapi.apitirage.modele.Listpost;

import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.Tirage;
import com.binomeapi.apitirage.repository.PosttirerRepository;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class TirageController {

    @Autowired
    private final TirageService tirageService;
    @Autowired
    private final ListpostService listpostService;
    @Autowired
    private final PostulantService postulantService;
    @Autowired
    private  final PosttirerService posttirerService;
    private  final PosttirerRepository posttirerRepository;

    @PostMapping("/createTirage/{libelle}/{nbre}")
    public String create(@RequestBody Tirage tirage, @PathVariable("libelle") String libelle, @PathVariable("nbre") Long nbre){

        Listpost listpost = listpostService.trouverListeParLibelle(libelle);
        List<Postulant> post = postulantService.Trouverid_Liste_postulant(listpost.getId_listPost());

        tirage.setNbPosTirer(nbre);
        List<Postulant> lp = tirageService.creer(tirage,post,nbre);
        Long id_tirage = tirageService.trouverTirageParLibelle(tirage.getLibelle()).getId_tirage();
        for (Postulant p : lp) {
            posttirerRepository.INSERTPOSTTIRE(p.getMail(), p.getNom(), p.getNumero(),p.getPrenom(),id_tirage );
        }

        return "tirage effectué avec succes";

    }

    @GetMapping(value = "/afficherlistetirage")
    public List<Tirage> list(){
        return tirageService.lister();
    }




  @GetMapping("/affichernbtirage/{libelle}")
  String nombre(@PathVariable String libelle) {

      return tirageService.nombre(libelle);
  }

  @GetMapping("/tirageParList/{id_listPost}")
  Iterable<Object[]> AfficherTirageParListe(@PathVariable Long id_listPost){
      return tirageService.AfficherTirageParListe(id_listPost);

  }

  @GetMapping("/nbrePostTirer/{id_tirage}")
  Long  myNbrePost(@PathVariable Long id_tirage){
    return tirageService.nbrePostTirer(id_tirage);
  }
}
