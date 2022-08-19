package com.binomeapi.apitirage.controller;

import com.binomeapi.apitirage.modele.Tirage;
import com.binomeapi.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tirage")
@AllArgsConstructor
public class TirageController {

    private final TirageService tirageService;

    @PostMapping("/trier")
    public Tirage trier(@RequestBody Tirage tirage){
        return tirageService.trier(tirage);
    }
}
