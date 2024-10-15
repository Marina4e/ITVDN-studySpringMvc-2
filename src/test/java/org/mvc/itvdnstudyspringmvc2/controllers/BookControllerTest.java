package org.mvc.itvdnstudyspringmvc2.controllers;

import org.junit.jupiter.api.Test;
import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testBookNameIsNotValid() throws Exception {
        var book = BookDTO.builder()
                .name("")
                .author("asdd")
                .description("sdf")
                .price(123D)
                .build();
        mockMvc.perform(post("/book/create")
                .flashAttr("bookDto", book))
                .andExpect(model().hasErrors())
                .andExpect(content()
                        .string(containsString("The book title cannot be empty")));

    }

    @Test
    void testCreateBookValid() throws Exception {
        var book = BookDTO.builder()
                .name("gk")
                .author("asdd")
                .description("sdf")
                .price(123D)
                .build();
        mockMvc.perform(post("/book/create")
                        .flashAttr("bookDto", book))
                .andExpect(model().hasNoErrors());

    }

}
