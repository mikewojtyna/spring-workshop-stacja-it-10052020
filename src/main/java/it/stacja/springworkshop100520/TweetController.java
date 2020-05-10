package it.stacja.springworkshop100520;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
@AllArgsConstructor
public class TweetController {

	private TweetRepository tweetRepository;

	@GetMapping
	public Iterable<Tweet> anything() {
		return tweetRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTweet(@RequestBody Tweet tweet) {
		tweetRepository.save(tweet);
	}
}
