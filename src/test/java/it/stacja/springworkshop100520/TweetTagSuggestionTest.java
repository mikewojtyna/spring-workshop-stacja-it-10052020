package it.stacja.springworkshop100520;

import it.stacja.springworkshop100520.core.domain.Rank;
import it.stacja.springworkshop100520.core.domain.Tweet;
import it.stacja.springworkshop100520.core.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static it.stacja.springworkshop100520.TestUtils.tweetCreatedByUserAndWithScore;
import static it.stacja.springworkshop100520.TestUtils.tweetWithMsg;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: implement domain logic, so all the tests pass
class TweetTagSuggestionTest {

	// @formatter:off
	@DisplayName(
	        "given tweet with content 'hello, this is my first tweet', " +
	        "when suggest tags for this tweet, " +
	        "then suggested tags are '#first', '#greeting'"
	)
	//@formatter:on
	@Test
	void suggestTags() throws Exception {
		// given
		var tweet = tweetWithMsg("hello, this is my first tweet");

		// when
		var tags = tweet.suggestTags();

		// then
		assertThat(tags.containsTags("#first", "#greeting")).isTrue();
	}

	// @formatter:off
	@DisplayName(
	        "given tweet created by Tom, who is a regular user, " +
	        "when Tom wants to promote his tweet, " +
	        "then promotion is declined, because it's reserved only for premium users"
	)
	//@formatter:on
	@Test
	void promoteFail() throws Exception {
		// given
		User tom = userNamed("Tom");
		Tweet tweet = tweetCreatedByUserAndWithScore(tom, 0);

		// when
		tweet.promote();

		// then
		assertThat(tweet.rank()).isEqualTo(Rank.ofValue(0));
	}

	// @formatter:off
	@DisplayName(
	        "given tweet created by George, who is a premium user, " +
	        "when George wants to promote his tweet, " +
	        "then promotion works and rank is increased by one"
	)
	//@formatter:on
	@Test
	void promoteSuccess() throws Exception {
		// given
		User tom = premiumUserNamed("George");
		Tweet tweet = tweetCreatedByUserAndWithScore(tom, 0);

		// when
		tweet.promote();

		// then
		assertThat(tweet.rank()).isEqualTo(Rank.ofValue(1));
	}

	private User premiumUserNamed(String name) {
		return null;
	}

	private User userNamed(String tom) {
		return null;
	}
}
