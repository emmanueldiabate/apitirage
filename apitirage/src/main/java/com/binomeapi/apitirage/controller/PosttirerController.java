package com.binomeapi.apitirage.controller;


import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.service.PosttirerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Posttirer")
@AllArgsConstructor
public class PosttirerController {

    @Autowired
    PosttirerService posttirerService;

    @GetMapping(value = "/afficherpostulanttire")
    public int create(Long id_post,String mail,String nom,String numero,String prenom, Long id_tirage){
        return posttirerService.creer(id_post, mail, nom, numero, prenom, id_tirage);
    }
}
