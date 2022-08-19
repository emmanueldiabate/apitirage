package com.binomeapi.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "POSTULANT")
@NoArgsConstructor
public class Postulant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post;
    private String mail;
    private String nom;
    private String prenom;
    private Long numero;




    public Postulant(String nom, String prenom, long numero, String email) {
    }
}
