package com.binomeapi.apitirage.modele;

import javax.persistence.*;

@Entity
@Table(name = "POSTTIRER")
public class Posttirer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_postTirer;

}
