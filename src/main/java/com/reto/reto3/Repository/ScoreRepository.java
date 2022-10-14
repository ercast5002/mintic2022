package com.reto.reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.ScoreCrudRepository;
import com.reto.reto3.model.Score;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

     //Los metodos

     public List<Score> getAll() {
        return (List<Score>)scoreCrudRepository.findAll();

    }

    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepository.save(score);

    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
    
    
}
