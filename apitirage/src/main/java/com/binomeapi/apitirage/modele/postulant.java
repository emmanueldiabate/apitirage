package com.binomeapi.apitirage.modele;

import javax.persistence.*;

@Entity
@Table(name = "postulant")
public class postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_post;
    private String nom;
    private String prenom;
    private String numero;
    private String email;
}
