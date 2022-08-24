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
    public int INSERTIDLIST(@Param("id_Liste_postulant") Long id_listPost);

}
