package com.api.controller;

import com.api.entity.StudentEntity;
import com.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private String validRequest;
    @InjectMocks
    private StudentController studentController;

    @MockBean
    private UserService userService;

    @Test
    public void saveUserTest() throws Exception {
        validRequest = "{\"id\":12345,\"name\":\"Shikha\",\"address\":\"Delhi\"}";
        mockMvc.perform(post("/saveData")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validRequest))
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void getServiceTest() throws Exception {
       validRequest = "{\"id\":1,\"name\":\"Shikha\",\"address\":\"UP\"}";
        mockMvc.perform(get("/useofService")
                       .contentType(MediaType.APPLICATION_JSON)
                        .content(validRequest))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getDataTest() throws Exception {
        validRequest = "{\"id\":12345,\"name\":\"Shikha\",\"address\":\"Delhi\"}";
        mockMvc.perform(get("/getData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validRequest))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateDataTest() throws Exception {
        validRequest = "{\"id\":12345,\"name\":\"Shikha\",\"address\":\"Delhi\"}";
        mockMvc.perform(put("/updateData/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validRequest))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void deleteDataTest() throws Exception {
        validRequest = "{\"id\":12345,\"name\":\"Shikha\",\"address\":\"Delhi\"}";
        mockMvc.perform(delete("/deleteData/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validRequest))
                .andExpect(status().is2xxSuccessful());

    }
}