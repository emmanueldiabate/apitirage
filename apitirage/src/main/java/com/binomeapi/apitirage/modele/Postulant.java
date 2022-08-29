package com.binomeapi.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "POSTULANT")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post;
    private String mail;
    private String nom;
    private String numero;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "id_listPost")
    private Listpost listpost;

    public Postulant(String mail, String nom, String numero, String prenom) {
        this.mail = mail;
        this.nom = nom;
        this.numero = numero;
        this.prenom = prenom;



    }
}
