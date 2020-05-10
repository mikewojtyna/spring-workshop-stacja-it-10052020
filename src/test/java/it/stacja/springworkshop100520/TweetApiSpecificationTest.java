package it.stacja.springworkshop100520;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TweetApiSpecificationTest {

	@Autowired
	private MockMvc mockMvc;

	// @formatter:off
	@DisplayName(
	        "when GET on /api/tweets, " +
	        "then 200 status is returned"
	)
	//@formatter:on
	@Test
	void get200() throws Exception {
		// when
		mockMvc.perform(get("/api/tweets"))

		       // then
		       .andExpect(status().isOk());
	}

	// @formatter:off
	@DisplayName(
	        "given one tweet in application, " +
	        "when GET on /api/tweets, " +
	        "then a list containing single tweet is returned"
	)
	//@formatter:on
	@Test
	void createTweet() throws Exception {
		// given
		String tweet = "{ \"msg\": \"hello\" }";

		// when
		mockMvc.perform(post("/api/tweets")
			.contentType(MediaType.APPLICATION_JSON)
			.content(tweet))

		       // then
		       .andExpect(status().isCreated());
		mockMvc
			.perform(get("/api/tweets"))
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].msg", is("hello")));
	}
}
