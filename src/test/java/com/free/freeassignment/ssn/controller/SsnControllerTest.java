package com.free.freeassignment.ssn.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SsnControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testValidateSsn() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("ssn", "010393-077J");
		obj.put("country_code", "FI");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/validate_ssn")
				.contentType(MediaType.APPLICATION_JSON)
				.content(obj.toString());
	
		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.jsonPath("$.ssn_valid", "ssn_valid").value(true))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

}
