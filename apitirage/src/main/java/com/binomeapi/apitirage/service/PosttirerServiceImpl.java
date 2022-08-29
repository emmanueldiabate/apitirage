package com.binomeapi.apitirage.service;

import com.binomeapi.apitirage.modele.Posttirer;
import com.binomeapi.apitirage.repository.PosttirerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosttirerServiceImpl implements PosttirerService{

    @Autowired
    PosttirerRepository posttirerRepository;

    @Override
    public List<Posttirer> lister() {
        return posttirerRepository.findAll();
    }

   @Override
    public Posttirer ajouter(Posttirer posttirer) {
        return posttirerRepository.save(posttirer);
    }

    @Override
    public Posttirer Save(Posttirer posttirer) {
        return posttirerRepository.save(posttirer);
    }


}
