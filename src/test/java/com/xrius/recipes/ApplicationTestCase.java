package com.xrius.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.http.HttpMethod.valueOf;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class ApplicationTestCase {
    @Autowired
    private MockMvc mockMvc;

    protected void assertResponse(
            String endpoint,
            Integer expectedStatusCode,
            String expectedResponse
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        mockMvc
                .perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

    protected void assertRequestWithBody(
            String method,
            String endpoint,
            String body,
            Integer expectedStatusCode
    ) throws Exception {
        mockMvc
                .perform(request(valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(content().string(""));
    }
}
