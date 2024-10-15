package org.mvc.itvdnstudyspringmvc2.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testHelloPage() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/")
                        .param("name", "Nelli"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(content().string(containsString("Привіт, як справи")));
    }

    @Test
    void testHelloPageWrongParam() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/")
                        .param("wrong", "Mik"))
                .andExpect(status().is4xxClientError());

    }
}
