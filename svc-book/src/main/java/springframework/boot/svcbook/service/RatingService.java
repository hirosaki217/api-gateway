package springframework.boot.svcbook.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import springframework.boot.svcbook.exception.RatingNotFoundException;
import springframework.boot.svcbook.model.Rating;
import springframework.boot.svcbook.repository.RatingRepository;



@Service
@Transactional(readOnly = true)
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    
    public List<Rating> findRatingsByBookId(Long bookId) {
        return ratingRepository.findRatingsByBookId(bookId);
    }


    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }



    public Optional<Rating> findRatingById(Long ratingId) {
        return Optional.ofNullable(ratingRepository.findById(ratingId))
            .orElseThrow(() -> new RatingNotFoundException("Rating not found. ID: " + ratingId));
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public Rating createRating(Rating rating) {
        Rating newRating = new Rating();
        newRating.setBookId(rating.getBookId());
        newRating.setStars(rating.getStars());
        Rating persisted = ratingRepository.save(newRating);
        return persisted;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Rating updateRating(Map<String, String> updates, Long ratingId) {
        final Optional<Rating> rating = findRatingById(ratingId);
        updates.keySet()
            .forEach(key -> {
                switch (key) {
                case "stars":
                    rating.get().setStars(Integer.parseInt(updates.get(key)));
                    break;
                }
            });
        Rating persisted = ratingRepository.save(rating.get());
        return persisted;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Rating updateRating(Rating rating, Long ratingId) {
        return ratingRepository.save(rating);
    }

}