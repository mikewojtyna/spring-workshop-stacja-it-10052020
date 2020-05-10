package it.stacja.springworkshop100520;

import org.springframework.data.repository.CrudRepository;

public interface TweetRepository extends CrudRepository<Tweet, String> {

	Iterable<Tweet> findByMsg(String msg);
	// TODO: add query method to find all messages ending with given suffix
}
