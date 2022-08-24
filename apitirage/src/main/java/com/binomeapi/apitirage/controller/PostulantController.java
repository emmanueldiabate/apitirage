package com.binomeapi.apitirage.controller;


import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.PostulantExcelimport;
import com.binomeapi.apitirage.repository.PostulantRepository;
import com.binomeapi.apitirage.service.ListpostService;
import com.binomeapi.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {

    @Autowired
    PostulantService postulantService;
    ListpostService listpostService;


    @PostMapping("/add")
    public Postulant Ajouter(Postulant postulant){

        return this.postulantService.Ajout(postulant);
    }
    @GetMapping("/liste")
    public List<Postulant> lister(){

        return postulantService.lister();
    }


    @RequestMapping("/import/excel/{libelle}")
    @ResponseBody
    public String importExcel(@Param("fichier") MultipartFile fichier, Listpost listpost, String libelle){

        PostulantExcelimport excelimporter = new PostulantExcelimport();

        List<Postulant> postulantList = excelimporter.excelImport(fichier);
        if(postulantList.size()==0){
            return "Fichier vide";
        }else{
            listpost.setDate(new Date());
            Listpost l = listpostService.creer(listpost);

            for (Postulant p:postulantList){
                p.setListpost(l);

            }
            postulantService.enregistrer(postulantList);
            return "import succsfully";
        }
      /*  if(postulantList != null){
            postulantRepository.saveAll(postulantList);
            //   postulantService.enregistrer(postulantList);

            return "Importer avec succes";
        }else{
            return "Eurrer d'importation !";
        }*/

    }



}

