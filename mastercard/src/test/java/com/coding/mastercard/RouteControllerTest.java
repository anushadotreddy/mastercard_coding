package com.coding.mastercard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.coding.mastercard.domain.Route;

public class RouteControllerTest extends MastercardApplicationTests {

	private static final String API = "http://localhost:8080/connected/";

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getIsConnected_YES() throws Exception {
		Route route = new Route("Boston", "Newark");
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
						.get(API + "?origin=" + route.getOrigin() + "&destination=" + route.getDestination()))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "yes");
	}

	@Test
	public void getIsConnected_Null_NO() throws Exception {
		Route route = new Route("boston", null);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
						.get(API + "?origin=" + route.getOrigin() + "&destination=" + route.getDestination()))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "no");
	}

	@Test
	public void getIsConnected1_YES() throws Exception {
		Route route = new Route("Boston", "Philadelphia");
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
						.get(API + "?origin=" + route.getOrigin() + "&destination=" + route.getDestination()))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "yes");
	}
	
	@Test
	public void getIsConnected_NO() throws Exception {
		Route route = new Route("Philadelphia", "Albany");
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
						.get(API + "?origin=" + route.getOrigin() + "&destination=" + route.getDestination()))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "yes");
	}

	@Test
	public void wrongInput_NO() throws Exception {
		Route route = new Route("Boston", "");
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
						.get(API + "?origin=" + route.getOrigin() + "&destination=" + route.getDestination()))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "no");
	}

	@Test
	public void wrongEndpoint_400() throws Exception {
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(API)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

}
