package com.binomeapi.apitirage.modele;

import javax.persistence.*;

@Entity
@Table(name = "POSTULANT")
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post;
    private String nom;
    private String prenom;
    private String numero;
    private String mail;
}
