package it.stacja.springworkshop100520.core.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Tweet {

	private String msg;
	private TweetId id;

	public Tweet(String msg) {
		this.msg = msg;
	}

	public Tags suggestTags() {
		// TODO: implement
		throw new UnsupportedOperationException("Implement this");
	}

	public void promote() {
		// TODO: implement
		throw new UnsupportedOperationException("Implement this");
	}

	public Rank rank() {
		// TODO: implement
		throw new UnsupportedOperationException("Implement this");
	}
}
