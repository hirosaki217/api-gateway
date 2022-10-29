package springframework.boot.svcbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import springframework.boot.svcbook.model.Rating;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long>{
    List<Rating> findRatingsByBookId(Long bookId);
}
