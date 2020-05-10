package it.stacja.springworkshop100520.core.domain;

import java.util.Optional;

public interface TweetRepository {

	Optional<Tweet> findById(String id);

	Tweet save(Tweet tweet);
}
