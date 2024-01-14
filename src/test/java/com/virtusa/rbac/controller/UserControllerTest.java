package com.virtusa.rbac.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.rbac.dto.LoginRequestDto;
import com.virtusa.rbac.dto.ResponseDto;
import com.virtusa.rbac.dto.UserRequestDto;
import com.virtusa.rbac.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Autowired
    private UserController userController;

    @Autowired
    private ObjectMapper objectMapper;

    // @Test
    // @DisplayName("TestingPostMethodRegisterApi")
    // public void RegisterUserPostMethodShouldReturnCreatedStatus() throws Exception {
    //     UserRequestDto userRequestDto = new UserRequestDto("dharmesh", "dharmesh@gmail.com", "dharmesh@123");
    //     ResultActions response = mockMvc.perform(post("/api/user/register")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(userRequestDto))
    //     );

    //     response.andExpect(MockMvcResultMatchers.status().isCreated())
    //             .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(jsonPath("$.status").value("Data processed successfully!"))
    //             .andExpect(jsonPath("$.statusCode").value("CREATED"));

    // }

    // @Test
    // @DisplayName("TestingPostMethodLoginApi")
    // public void LoginUserPostMethodShouldReturnBadRequestStatus() throws Exception{
    //     LoginRequestDto loginRequestDto = new LoginRequestDto("dharmesh@gmail.com", "dharmesh@12");
    //     ResultActions response = mockMvc.perform(post("/api/user/login")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(loginRequestDto))
    //     );

    //     response.andExpect(MockMvcResultMatchers.status().isBadRequest())
    //             .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(jsonPath("$.status").value("Data couldn't be processed successfully!"))
    //             .andExpect(jsonPath("$.statusCode").value("BAD_REQUEST"));
    // }

    // @Test
    // @DisplayName("TestingGetMethodGetUserApi")
    // public void GetUserGetMethodShouldReturnOkStatus() throws Exception{
    //     ResultActions response = mockMvc.perform(get("/api/user")
    //             .param("userId", "1001")
    //             .contentType(MediaType.APPLICATION_JSON)
    //     );

    //     response.andExpect(MockMvcResultMatchers.status().isOk())
    //             .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(jsonPath("$.status").value("Data processed successfully!"))
    //             .andExpect(jsonPath("$.statusCode").value("OK"));

    // }

    // @Test
    // @DisplayName("TestingDeleteMethodDeleteUserApi")
    // public void DeleteUserDeleteMethodShouldReturnInternalServerErrorStatus() throws Exception{
    //     ResultActions response = mockMvc.perform(delete("/api/user")
    //             .param("userId", "1001")
    //             .contentType(MediaType.APPLICATION_JSON)
    //     );

    //     response.andExpect(MockMvcResultMatchers.status().isInternalServerError())
    //             .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(jsonPath("$.status").value("Data couldn't be processed successfully!"))
    //             .andExpect(jsonPath("$.statusCode").value("INTERNAL_SERVER_ERROR"));

    // }

    // @Test
    // @DisplayName("TestingDeleteMethodDeleteUserApi")
    // public void DeleteUserDeleteMethodShouldReturnOkStatus(){
    //     Long userId = 1011L;
    //     when(this.userService.deleteUserByUserId(userId)).thenReturn(true);
    //     System.out.println(this.userService.deleteUserByUserId(userId));
    //     ResponseEntity<ResponseDto<String>> response = this.userController.deleteUser(userId);
    //     Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    //     Assertions.assertNotNull(Objects.requireNonNull(response.getBody()).responseTime());
    //     Assertions.assertNotNull(response.getBody().data());
    //     Assertions.assertEquals(HttpStatus.OK, response.getBody().statusCode());


    // }

    // @Test
    // @DisplayName("TestingPostMethodLoginApi")
    // public void LoginUserPostMethodShouldReturnOkStatus(){
    //     LoginRequestDto loginRequestDto = new LoginRequestDto("dharmesh@gmail.com", "dharmesh@123");
    //     when(this.userService.validateUser(loginRequestDto)).thenReturn(true);
    //     System.out.println(this.userService.validateUser(loginRequestDto));
    //     ResponseEntity<ResponseDto<String>> response = this.userController.loginUser(loginRequestDto);
    //     Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    //     Assertions.assertNotNull(Objects.requireNonNull(response.getBody()).responseTime());
    //     Assertions.assertNotNull(response.getBody().data());
    //     Assertions.assertEquals(HttpStatus.OK, response.getBody().statusCode());
    // }


}
