package com.binomeapi.apitirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LISTPOST")
@Getter
@Setter
@NoArgsConstructor
public class Listpost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_listPost;
    private String libelle;
    private Date date;
}
