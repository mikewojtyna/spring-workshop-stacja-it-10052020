package it.stacja.springworkshop100520.core.infrastructure.spring;

import it.stacja.springworkshop100520.core.api.read.QueryTweetUseCase;
import it.stacja.springworkshop100520.core.api.read.TweetDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweets")
public class QueryTweetController {

	private QueryTweetUseCase tweetService;

	public QueryTweetController(QueryTweetUseCase tweetService) {
		this.tweetService = tweetService;
	}

	@GetMapping
	public Iterable<TweetDto> getAll() {
		return tweetService.getAll();
	}

	@GetMapping(params = {"msg"})
	public Iterable<TweetDto> findByMsg(@RequestParam("msg") String msg) {
		return tweetService.findByMsg(msg);
	}
}
