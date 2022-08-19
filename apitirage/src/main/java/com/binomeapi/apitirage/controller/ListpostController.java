package com.binomeapi.apitirage.controller;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.service.ListpostService;
import com.binomeapi.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/Listpost")
@AllArgsConstructor
public class ListpostController implements Serializable {

    private final ListpostService listpostService;

    @PostMapping("/importer")
    public Listpost ajouter(@RequestBody Listpost listpost){

        return listpostService.importer(listpost);
    }

    @GetMapping("/afficher")
    public List<Listpost> lire(){
        return listpostService.lire();
    }
}
