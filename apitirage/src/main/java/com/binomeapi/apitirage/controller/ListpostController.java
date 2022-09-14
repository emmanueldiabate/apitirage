package com.binomeapi.apitirage.controller;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.repository.ListpostRepository;
import com.binomeapi.apitirage.service.ListpostService;
import com.binomeapi.apitirage.service.ListpostServiceImpl;
import com.binomeapi.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/Listpost")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ListpostController {

    @Autowired
    ListpostService listpostService;

    @Autowired
    ListpostServiceImpl listpost;

    @Autowired
    ListpostRepository listpostRepository;

    PostulantService postulantService;

    @PostMapping("/add/{libelle}")
    public List<Postulant> liste(){
        return postulantService.lister();
    }
    @GetMapping("/Afficher")
    List<Listpost> lister(){
        return listpost.lister();
    }

    @GetMapping("/nbrePostT/{id_list_post}")
    Iterable<Object[]> trverIdList(@PathVariable Long id_list_post){
      return listpostService.trverIdList(id_list_post);
    }
}


 /* @GetMapping("/affichernbtirage/{libelle}")
  String nombre(@PathVariable String libelle) {
    return listpost.nombre(libelle);
  }*/

