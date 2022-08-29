package com.binomeapi.apitirage.repository;

import com.binomeapi.apitirage.modele.Listpost;
import com.binomeapi.apitirage.modele.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {

    //SQL pour tirage
    @Query(value = "SELECT * FROM postulant WHERE id_list_post =id_list_post", nativeQuery = true)
    //List<Postulant> FINDIDPOSTLIST(Long id_post);
    List<Postulant> findByIdPost(Long id_list_post);

    List<Postulant> findByListpost(Listpost listpost);
}
