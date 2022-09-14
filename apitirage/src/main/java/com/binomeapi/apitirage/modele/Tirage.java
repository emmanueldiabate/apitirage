package com.binomeapi.apitirage.modele;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIRAGE")
@Data
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tirage;
    private String libelle;
    private Date date;
    private Long nbPosTirer;

    @ManyToOne
    private Listpost listpost;

}
