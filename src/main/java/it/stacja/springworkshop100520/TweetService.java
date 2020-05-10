package it.stacja.springworkshop100520;

import io.vavr.control.Either;

public interface TweetService {

	Either<FailMessage, Tweet> create(Tweet tweet);

	Iterable<Tweet> getAll();

	Iterable<Tweet> findByMsg(String msg);
}
