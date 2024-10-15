package org.mvc.itvdnstudyspringmvc2.controllers.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@SpringBootTest
//@AutoConfigureMockMvc
//class BookRestControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Test
//    public void testGetAllBooks() throws Exception {
//        var mockResponse = mockMvc.perform(get("/api/book/all"))
//                .andReturn()
//                .getResponse();
//
//        var books = objectMapper.readValue(mockResponse.getContentAsString(), new TypeReference<List<BookDTO>>() {
//        });
//
//        assertEquals(4, books.size());
//        assertEquals(1, books.get(0).getId());
//    }
//
//    @Test
//    public void testCreateBook() throws Exception {
//        var book = BookDTO.builder()
//                .id(12L)
//                .name("Book12")
//                .author("sdag")
//                .description("sdg")
//                .price(123D)
//                .build();
//
//        var content = objectMapper.writeValueAsString(book);
//
//        var mockResponse = mockMvc.perform(post("/api/book/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content))
//                .andReturn()
//                .getResponse();
//
//        assertEquals(HttpStatus.OK.value(), mockResponse.getStatus());
//    }
//
//    @Test
//    public void testCreateBook_InvalidName() throws Exception {
//        var book = BookDTO.builder()
//                .id(12L)
//                .name("TestBook1")
//                .author("sdag")
//                .description("sdg")
//                .price(123D)
//                .build();
//
//        var content = objectMapper.writeValueAsString(book);
//
//        var mockResponse = mockMvc.perform(post("/api/book/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content))
//                .andReturn()
//                .getResponse();
//
//        assertEquals(HttpStatus.BAD_REQUEST.value(), mockResponse.getStatus());
//        assertTrue(mockResponse.getContentAsString()
//                .contains("The book with this title already exists"));
//    }
//
//}