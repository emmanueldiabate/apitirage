package com.binomeapi.apitirage.controller;


import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.service.PosttirerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Posttirer")
@AllArgsConstructor
public class PosttirerController {

    private final PosttirerService posttirerService;

    @GetMapping("/afficher")
    public List<Posttirer> lire(){
        return posttirerService.afficherPostTirer();
    }
}
