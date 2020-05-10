package it.stacja.springworkshop100520;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class TweetApiSpecificationIT {

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
	        "given hello tweet as json, " +
	        "when POST on /api/tweets with hello tweet, " +
	        "then this tweet is created"
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

	// @formatter:off
	@DisplayName(
	        "given tweets with messages hi, hello and welcome in the database, " +
	        "when GET on /api/tweets?msg=hello, " +
	        "then only hello tweet is returned"
	)
	//@formatter:on
	@Test
	void searchByMsg() throws Exception {
		// given
		String hi = "{ \"msg\": \"hi\" }";
		String hello = "{ \"msg\": \"hello\" }";
		String welcome = "{ \"msg\": \"welcome\" }";
		mockMvc.perform(post("/api/tweets")
			.contentType(MediaType.APPLICATION_JSON)
			.content(hi));
		mockMvc.perform(post("/api/tweets")
			.contentType(MediaType.APPLICATION_JSON)
			.content(hello));
		mockMvc.perform(post("/api/tweets")
			.contentType(MediaType.APPLICATION_JSON)
			.content(welcome));

		// when
		mockMvc.perform(get("/api/tweets").param("msg", "hello"))

		       // then
		       .andExpect(jsonPath("$", hasSize(1)))
		       .andExpect(jsonPath("$[0].msg", is("hello")));
	}

	// TODO: add test to find tweets ending with given suffix
}
