package com.binomeapi.apitirage.repository;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {

    //SQL pour tirage
    @Query(value = "SELECT * FROM postulant WHERE id_post = :id_post", nativeQuery = true)
    List<Postulant> FINDIDPOSTLIST(Long id_listPost);

    List<Postulant> findByListePostulant(Listpost postulant);
}
