package it.stacja.springworkshop100520;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

	private Tweet tweet = new Tweet("msg");

	@GetMapping
	public List<Tweet> anything() {
		return List.of(tweet);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTweet(@RequestBody Tweet tweet) {
		this.tweet = tweet;
	}
}
