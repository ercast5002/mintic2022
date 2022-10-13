package com.reto.reto3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.reto3.Service.ScoreService;
import com.reto.reto3.model.Score;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
            public List<Score> getAll() {
            return scoreService.getAll();
            
        }

    @GetMapping("/{id}")
           public Optional<Score> getScore (@PathVariable("id") int id){
           return scoreService.getScore(id);
}

@GetMapping("/save")
@ResponseStatus(HttpStatus.CREATED)
           public Score save (@RequestBody Score score){
           return scoreService.save(score);


}
    
}
