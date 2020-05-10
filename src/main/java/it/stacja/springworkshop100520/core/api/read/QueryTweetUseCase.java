package it.stacja.springworkshop100520.core.api.read;

public interface QueryTweetUseCase {

	Iterable<TweetDto> getAll();

	Iterable<TweetDto> findByMsg(String msg);
}
