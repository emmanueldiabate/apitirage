package com.binomeapi.apitirage.modele;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tirage")
public class tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_tirage;
    private String libelle;
    private Date date;
}
