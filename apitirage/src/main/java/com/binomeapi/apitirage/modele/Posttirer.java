package com.binomeapi.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posttirer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_postTirer;

    @ManyToOne
    private Tirage tirage;

}
