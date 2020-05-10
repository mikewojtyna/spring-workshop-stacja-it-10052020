package it.stacja.springworkshop100520.core.infrastructure.spring;

import org.springframework.data.repository.CrudRepository;

public interface SpringTweetRepository extends CrudRepository<TweetDocument, String> {

	Iterable<TweetDocument> findByMsg(String msg);
	// TODO: add query method to find all messages ending with given suffix
}
