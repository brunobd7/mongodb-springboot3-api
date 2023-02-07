package dev.dantas.movieapimongodb.service;

import dev.dantas.movieapimongodb.model.Movie;
import dev.dantas.movieapimongodb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> listAllMovie(){
        return movieRepository.findAll();
    }


}
