package it.stacja.springworkshop100520.core.api.create.impl;

import io.vavr.control.Either;
import it.stacja.springworkshop100520.core.api.create.CreateTweetCommand;
import it.stacja.springworkshop100520.core.api.create.CreateTweetUseCase;
import it.stacja.springworkshop100520.core.api.create.FailMessage;
import it.stacja.springworkshop100520.core.domain.TweetId;
import it.stacja.springworkshop100520.core.domain.TweetRepository;

public class RepositoryCreateTweetUseCase implements CreateTweetUseCase {

	private TweetRepository tweetRepository;

	public RepositoryCreateTweetUseCase(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	@Override
	public Either<FailMessage, TweetId> create(CreateTweetCommand command) {
		// TODO: implement
		throw new UnsupportedOperationException("implement this");
	}
}
