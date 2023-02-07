package dev.dantas.movieapimongodb.service;

import dev.dantas.movieapimongodb.model.Movie;
import dev.dantas.movieapimongodb.model.Review;
import dev.dantas.movieapimongodb.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    private MongoTemplate mongoTemplate;


    public Review createReview(String body, String imdbId) {

        Review reviewCreated = reviewRepository.insert(new Review(body));

        mongoTemplate
                .update(Movie.class)
                .matching(Criteria.where("imdbID").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviewCreated));


        return reviewCreated;
    }
}
