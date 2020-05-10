package it.stacja.springworkshop100520;

import io.vavr.control.Either;
import org.springframework.stereotype.Service;

@Service
public class TweetServiceImpl implements TweetService {

	private TweetRepository tweetRepository;

	public TweetServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	@Override
	public Either<FailMessage, Tweet> create(Tweet tweet) {
		try {
			Tweet savedTweet = tweetRepository.save(tweet);
			return Either.right(savedTweet);
		}
		catch (Exception e) {
			return Either.left(new FailMessage());
		}

	}

	@Override
	public Iterable<Tweet> getAll() {
		return tweetRepository.findAll();
	}

	@Override
	public Iterable<Tweet> findByMsg(String msg) {
		return tweetRepository.findByMsg(msg);
	}
}
