package com.reto.reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.reto3.Repository.ScoreRepository;
import com.reto.reto3.model.Score;

@Service
public class ScoreService {
   
    @Autowired
   private ScoreRepository scoreRepository; 

   // creamos los servicios 
   public List<Score> getAll() {
    return (List<Score>)scoreRepository.getAll();

}

public Optional<Score> getScore(int id){
    return scoreRepository.getScore(id);
}

// metodo post o guardar
public Score save (Score score){
    if(score.getIdScore()== null){
        return scoreRepository.save(score);
  
    }else{
        Optional<Score> scoreEncontrado = scoreRepository.getScore(score.getIdScore());
        if(scoreEncontrado.isEmpty()){
            return scoreRepository.save(score);

        }else{
            return score;
        }
    }

}

// Actualizar datos
public Score update(Score score){
    if(score.getIdScore() !=null){
        Optional<Score> scoreEncontrado = getScore(score.getIdScore());
        if(!scoreEncontrado.isEmpty()){
            if(score.getMessegeText() !=null){
                scoreEncontrado.get().setMessegeText(score.getMessegeText());
            }
            if(score.getStars() != null){
                scoreEncontrado.get().setStars(score.getStars());
            }
            
            return scoreRepository.save(scoreEncontrado.get());
        }
    }
    return score;
}

// Metodo eliminar

public boolean delete(int Id){
    Boolean resultado = getScore(Id).map(scorePorEliminar ->{
        scoreRepository.delete(scorePorEliminar);
        return true ;
    }).orElse(false);
    return resultado;
}


    
}
