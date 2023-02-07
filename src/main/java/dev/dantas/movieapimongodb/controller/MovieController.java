package dev.dantas.movieapimongodb.controller;

import dev.dantas.movieapimongodb.model.Movie;
import dev.dantas.movieapimongodb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> listAllMovies(){
        return ResponseEntity.ok(movieService.listAllMovie());
    }
}
