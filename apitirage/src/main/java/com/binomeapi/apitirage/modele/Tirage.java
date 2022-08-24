package com.binomeapi.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIRAGE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tirage;
    private String libelle;
    private Date date;
  //  private Long nbPosTirer;

    @ManyToOne
    private Listpost listpost;

}
