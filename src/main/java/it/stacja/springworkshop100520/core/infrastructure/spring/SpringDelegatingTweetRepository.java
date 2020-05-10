package it.stacja.springworkshop100520.core.infrastructure.spring;

import it.stacja.springworkshop100520.core.domain.Tweet;
import it.stacja.springworkshop100520.core.domain.TweetRepository;

import java.util.Optional;

public class SpringDelegatingTweetRepository implements TweetRepository {

	private SpringTweetRepository springTweetRepository;

	public SpringDelegatingTweetRepository(SpringTweetRepository springTweetRepository) {
		this.springTweetRepository = springTweetRepository;
	}

	@Override
	public Optional<Tweet> findById(String id) {
		// TODO: translate and return
		return Optional.empty();
	}

	@Override
	public Tweet save(Tweet tweet) {
		// TODO: translate and save
		return null;
	}
}
