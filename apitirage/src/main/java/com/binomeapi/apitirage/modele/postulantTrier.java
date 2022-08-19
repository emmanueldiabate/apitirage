package com.binomeapi.apitirage.modele;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "postulantTrier")
@Getter//génère le getter
@Setter//génère le setter
@NoArgsConstructor//génère le constructeur sans les arguments
public class postulantTrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//mode de generation de clé
    private Long id_post_tirer;

}
