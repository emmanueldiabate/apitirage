package com.binomeapi.apitirage.repository;

import com.binomeapi.apitirage.modele.Posttirer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PosttirerRepository extends JpaRepository<Posttirer, Long> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO posttirer(mail,nom,numero,prenom,tirage_id_tirage) VALUES (?,?,?,?,?)",nativeQuery = true)
    public int INSERTPOSTTIRE(String mail,String nom,String numero,String prenom, Long id_tirage);

}
