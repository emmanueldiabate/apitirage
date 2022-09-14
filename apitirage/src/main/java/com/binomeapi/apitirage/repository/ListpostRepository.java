package com.binomeapi.apitirage.repository;

import com.binomeapi.apitirage.modele.Listpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ListpostRepository extends JpaRepository<Listpost, Long> {

    Listpost findByLibelle(String libelle);
    @Modifying
    @Transactional
    @Query(value = "insert into postulant(id_listPost) VALUES (:id_listPost);", nativeQuery = true)
    public int INSERTIDLIST(@Param("id_listPost") Long id_listPost);

    @Query(value = "SELECT * FROM `listpost` WHERE listpost.id_list_post=:id_list_post",nativeQuery = true)
    Iterable<Object[]> trverIdList(Long id_list_post);

  /*@Query(value = "SELECT count(id_tirage) FROM tirage, lispost WHERE tirage.id_list=listpost.id_list_post AND lispost.libelle=? GROUPE BY id_list_post", nativeQuery = true)
    String nombre(String libelle);*/
}
