package com.binomeapi.apitirage.controller;


import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.modele.PostulantExcelimport;
import com.binomeapi.apitirage.repository.PostulantRepository;
import com.binomeapi.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {

    @Autowired
    private PostulantRepository postulantRepository;
    // private PostulantService postulantService;

    @RequestMapping("/import/excel")
    @ResponseBody
    public String importExcel(){
        PostulantExcelimport excelimporter = new PostulantExcelimport();
        List<Postulant> postulantList = excelimporter.excelImport();
        if(postulantList != null){
            postulantRepository.saveAll(postulantList);
            //   postulantService.enregistrer(postulantList);

            return "Importer avec succes";
        }else{
            return "null null null null";
        }

    }

}

