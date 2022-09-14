package com.binomeapi.apitirage.repository;

import com.binomeapi.apitirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TirageRepository extends JpaRepository<Tirage, Long> {

    Tirage findByLibelle(String libelle);
    @Query(value = "SELECT  count(id_tirage) FROM tirage, listpost WHERE tirage.listpost_id_list_post=listpost.id_list_post AND listpost.libelle=?", nativeQuery = true)
    String nombre(String libelle);

    @Query(value = "SELECT * FROM `tirage` WHERE tirage.listpost_id_list_post=:listpost_id_list_post", nativeQuery = true)
    Iterable<Object[]> AfficherTirageParListe(Long listpost_id_list_post);

    @Query(value = "SELECT COUNT(tirage_id_tirage) FROM `posttirer` WHERE posttirer.tirage_id_tirage=:tirage_id_tirage",nativeQuery = true)
    Long nbrePostTirer(Long tirage_id_tirage);

}
/*tirage.id_tirage,tirage.date, tirage.libelle,*/
