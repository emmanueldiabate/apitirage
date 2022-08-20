package com.binomeapi.apitirage.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
<<<<<<< HEAD
import java.io.Serializable;
=======
>>>>>>> fd5e440002488b91247838aaf07914142b900f62
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
<<<<<<< HEAD
=======

>>>>>>> fd5e440002488b91247838aaf07914142b900f62
}
