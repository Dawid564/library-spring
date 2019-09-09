package com.example.controller;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.library.LibraryApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={LibraryApplication.class})
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private ApiController apiController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(apiController).isNotNull();
    }

    @Test
    public void testTest() throws Exception {
        this.mockMvc.perform(get("/api/test").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void testBookByIsbn() throws Exception {
        this.mockMvc.perform(get("/api/book/{isbn}","9780080568782").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void testBooksByCategory() throws Exception {
        this.mockMvc.perform(get("/api/category/{category}/books","Computers").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void testAuthorRating() throws Exception {
        this.mockMvc.perform(get("/api/rating").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }


    @Configuration
    @EnableWebMvc
    public static class TestConfiguration{

        @Bean
        public ApiController apiController(){
            return new ApiController();
        }
    }
}
