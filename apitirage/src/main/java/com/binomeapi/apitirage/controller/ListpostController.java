package com.binomeapi.apitirage.controller;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.modele.Postulant;
import com.binomeapi.apitirage.repository.ListpostRepository;
import com.binomeapi.apitirage.service.ListpostService;
import com.binomeapi.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/Listpost")
@AllArgsConstructor
public class ListpostController implements Serializable {

    @Autowired
    ListpostRepository listpostRepository;

    PostulantService postulantService;

    @PostMapping("/add/{libelle}")
    public List<Postulant> liste(){
        return postulantService.lister();
    }

}
