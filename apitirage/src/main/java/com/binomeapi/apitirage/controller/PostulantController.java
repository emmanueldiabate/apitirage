package com.binomeapi.apitirage.controller;


import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.PostulantExcelimport;

import com.binomeapi.apitirage.service.ListpostService;
import com.binomeapi.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
@NoArgsConstructor
public class PostulantController {
    @Autowired
    ListpostService listpostService;

    @Autowired
    PostulantService postulantService;

    Postulant postulant;


    @PostMapping("/add")
    public Postulant create(@RequestBody Postulant postulant){

        return postulantService.creer(postulant);
    }

    @GetMapping("/liste")
    public List<Postulant> lister(){

        return postulantService.lister();
    }

    @RequestMapping("/import/excel/{libelle}")
    @ResponseBody
    public String importExcel(@Param("fichier") MultipartFile fichier, Listpost listpost, String libelle) {

        PostulantExcelimport excelimporter = new PostulantExcelimport();

        List<Postulant> postulantList = excelimporter.excelImport(fichier);
        if (postulantList.size() == 0) {
            return "Votre fichier est vide";
        } else {
            listpost.setDate(new Date());
            Listpost l = listpostService.creer(listpost);

            for (Postulant p : postulantList) {
                p.setListpost(l);

            }
            postulantService.enregistrer(postulantList);
            return "importer avec succes";
        }
    }

    @PutMapping("/modifierPostulant/{id_post}")
    public Postulant update(@PathVariable Long id_post , @RequestBody Postulant postulant) {

        return postulantService.modifier(id_post,postulant);
    }

    @DeleteMapping("/supprimerPostulant/{id_post}")
    public String delete(@PathVariable Long id_post){

        return postulantService.supprimer(id_post);
    }
}





