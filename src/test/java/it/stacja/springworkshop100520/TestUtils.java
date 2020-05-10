package it.stacja.springworkshop100520;

import it.stacja.springworkshop100520.core.domain.Tweet;
import it.stacja.springworkshop100520.core.domain.User;

public class TestUtils {

	public static Tweet tweetWithMsg(String msg) {
		return new Tweet(msg);
	}

	public static Tweet tweetCreatedBy(User tom) {

		return null;
	}

	public static Tweet tweetCreatedByUserAndWithScore(User tom, int score) {
		return null;
	}
}
