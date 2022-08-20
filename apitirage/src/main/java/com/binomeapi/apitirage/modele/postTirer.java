package com.binomeapi.apitirage.modele;

import javax.persistence.*;

@Entity
@Table(name = "POSTTIRER")
public class postTirer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_posTirer;

}
