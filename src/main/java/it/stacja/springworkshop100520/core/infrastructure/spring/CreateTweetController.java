package it.stacja.springworkshop100520.core.infrastructure.spring;

import it.stacja.springworkshop100520.core.api.create.CreateTweetCommand;
import it.stacja.springworkshop100520.core.api.create.CreateTweetUseCase;
import it.stacja.springworkshop100520.core.domain.TweetId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
public class CreateTweetController {

	private CreateTweetUseCase createTweetUseCase;

	public CreateTweetController(CreateTweetUseCase createTweetUseCase) {
		this.createTweetUseCase = createTweetUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TweetId createTweet(@RequestBody CreateTweetCommand tweet) {
		return createTweetUseCase
			.create(tweet)
			.getOrElseThrow(() -> new ControllerDtoException("failed to create tweet"));
	}
}
