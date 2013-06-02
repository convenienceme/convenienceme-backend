package me.convenience.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import me.convenience.api.AbstractContextControllerTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
public class TestAPIController extends AbstractContextControllerTests {

	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}
	
	
	@Test
	public void getDashBoard() throws Exception {
		this.mockMvc.perform(get("/dashboard?userid=jay"))
				.andExpect(jsonPath("$.products[0].status").value(10))
				.andExpect(jsonPath("$.products[1].status").value(90));
	}
	
	
}
