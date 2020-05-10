package it.stacja.springworkshop100520.core.infrastructure.spring;

import it.stacja.springworkshop100520.core.api.create.CreateTweetUseCase;
import it.stacja.springworkshop100520.core.api.promote.PromoteTweetUseCase;
import it.stacja.springworkshop100520.core.api.read.QueryTweetUseCase;
import it.stacja.springworkshop100520.core.api.read.SuggestTagsUseCase;
import it.stacja.springworkshop100520.core.domain.TweetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

	@Bean
	public CreateTweetUseCase createTweetUseCase() {
		// TODO: provide implementation
		throw new UnsupportedOperationException("Implement this method");
	}

	@Bean
	public PromoteTweetUseCase promoteTweetUseCase() {
		// TODO: provide implementation
		throw new UnsupportedOperationException("Implement this method");
	}

	@Bean
	public QueryTweetUseCase queryTweetUseCase() {
		// TODO: implement
		throw new UnsupportedOperationException("Implement this method");
	}

	@Bean
	public SuggestTagsUseCase suggestTagsUseCase() {
		// TODO: implement
		throw new UnsupportedOperationException("Implement this method");
	}

	@Bean
	public TweetRepository tweetRepository(SpringTweetRepository springRepo) {
		return new SpringDelegatingTweetRepository(springRepo);
	}
}
