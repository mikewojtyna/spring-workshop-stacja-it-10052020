package it.stacja.springworkshop100520;

import io.vavr.control.Either;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TweetController.class)
class TweetApiSpecificationTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private TweetService tweetService;

	// @formatter:off
	@DisplayName(
		"when GET on /api/tweets, " +
		"then all tweets are returned"
	)
	//@formatter:on
	@Test
	void get200() throws Exception {
		// given
		when(tweetService.getAll()).thenReturn(
			List.of(tweetWithMsg("hi"), tweetWithMsg("hello"), tweetWithMsg("welcome")));

		// when
		mockMvc.perform(get("/api/tweets"))

		       // then
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$", hasSize(3)))
		       .andExpect(jsonPath("$[0].msg", is("hi")))
		       .andExpect(jsonPath("$[1].msg", is("hello")))
		       .andExpect(jsonPath("$[2].msg", is("welcome")));
	}

	// @formatter:off
	@DisplayName(
	        "given hello tweet as json, " +
	        "when POST on /api/tweets with hello tweet, " +
	        "then this tweet is created"
	)
	//@formatter:on
	@Test
	void createTweet() throws Exception {
		// given
		String tweet = "{ \"msg\": \"hello\" }";
		Tweet expectedTweet = tweetWithMsg("hello");
		when(tweetService.create(expectedTweet)).thenReturn(Either.right(expectedTweet));

		// when
		mockMvc.perform(post("/api/tweets")
			.contentType(MediaType.APPLICATION_JSON)
			.content(tweet))

		       // then
		       .andExpect(status().isCreated());
		verify(tweetService).create(expectedTweet);
	}

	// @formatter:off
	@DisplayName(
	        "when GET on /api/tweets?msg=hello, " +
	        "then only tweets with message are returned"
	)
	//@formatter:on
	@Test
	void searchByMsg() throws Exception {
		// given
		when(tweetService.findByMsg("hello")).thenReturn(List.of(new Tweet("hello")));

		// when
		mockMvc.perform(get("/api/tweets").param("msg", "hello"))

		       // then
		       .andExpect(jsonPath("$", hasSize(1)))
		       .andExpect(jsonPath("$[0].msg", is("hello")));
	}

	private Tweet tweetWithMsg(String msg) {
		return new Tweet(msg);
	}

	// TODO: add test to find tweets ending with given suffix
}
