package it.stacja.springworkshop100520;

import org.springframework.data.repository.CrudRepository;

public interface TweetRepository extends CrudRepository<Tweet, String> {

}
