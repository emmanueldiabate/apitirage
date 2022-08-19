package com.binomeapi.apitirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity//Permet de mapper la classe avec une table avec la base de donnée
@Table(name = "TIRAGE")
@Getter//génération automatic du getter
@Setter//génération automatic du setter
@NoArgsConstructor//génération automatic du constructeur sans argument
public class Tirage {

    @Id//Permet de mapper l'identifient
    @GeneratedValue(strategy = GenerationType.IDENTITY)// mode de génération automatic de la clé primaire
    private Long id_tirage;
    private String libelle;
    private Date date;
    private Long nbPosTirer;
}
