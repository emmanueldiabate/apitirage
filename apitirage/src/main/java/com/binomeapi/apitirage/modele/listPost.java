package com.binomeapi.apitirage.modele;


import javax.persistence.*;
import java.sql.Date;

@Entity //Permet de mapper la classe avec une table au niveau de la base de donnée
@Table(name = "listpost")
public class listPost {

    @Id //precise l'identifiant de la table concernée
    @GeneratedValue(strategy = GenerationType.IDENTITY) //

    private Long id_list_post;
    private String libelle;
    private Date date;
}
