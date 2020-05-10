package it.stacja.springworkshop100520.core.api.create;

import io.vavr.control.Either;
import it.stacja.springworkshop100520.core.domain.TweetId;

public interface CreateTweetUseCase {

	Either<FailMessage, TweetId> create(CreateTweetCommand command);
}
