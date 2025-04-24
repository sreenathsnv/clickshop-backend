package com.trivium.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trivium.entity.UserReview;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
	List<UserReview> findByProductId(Long productId);
	Optional<UserReview> findById(Long reviewId);
    Optional<UserReview> findByUsernameAndProductId(String username, Long productId);
	List<UserReview> findByUsername(String reviewUserId);

}
