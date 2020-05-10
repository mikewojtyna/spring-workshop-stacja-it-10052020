package it.stacja.springworkshop100520;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
@AllArgsConstructor
public class TweetController {

	private TweetService tweetService;

	@GetMapping
	public Iterable<Tweet> getAll() {
		return tweetService.getAll();
	}

	@GetMapping(params = {"msg"})
	public Iterable<Tweet> findByMsg(@RequestParam("msg") String msg) {
		return tweetService.findByMsg(msg);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tweet createTweet(@RequestBody Tweet tweet) {
		return tweetService
			.create(tweet)
			.getOrElseThrow(() -> new ControllerDtoException("failed to create tweet"));
	}
}
