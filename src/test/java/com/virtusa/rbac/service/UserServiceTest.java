package com.virtusa.rbac.service;

import com.virtusa.rbac.dto.UserRequestDto;
import com.virtusa.rbac.entity.User;
import com.virtusa.rbac.exception.UserAlreadyExistsException;
import com.virtusa.rbac.exception.UserNotFoundException;
import com.virtusa.rbac.repository.UserRepository;
import com.virtusa.rbac.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("TestingUserExistsMethodWithParamStringUsernameReturnsTrue")
    public void UserExistsMethodWithParamStringUsernameReturnsTrue(){
        User user = new User(100L, "dharmesh", "dharmesh@gmail.com", "dx@123", "ROLE_USER");
        when(this.userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        Assertions.assertTrue(this.userService.userExists(user.getUsername()));
    }

    @Test
    @DisplayName("TestingUserExistsMethodWithParamStringUsernameReturnsFalse")
    public void UserExistsMethodWithParamStringUsernameReturnsFalse(){
        when(this.userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        Assertions.assertFalse(this.userService.userExists("john"));
    }

    @Test
    @DisplayName("TestingUserExistsMethodWithParamLongUserIdReturnsTrue")
    public void UserExistsMethodWithParamLongUserIdReturnsTrue(){
        User user = new User(100L, "dharmesh", "dharmesh@gmail.com", "dx@123", "ROLE_USER");
        when(this.userRepository.findByUserId(user.getUserId())).thenReturn(Optional.of(user));
        Assertions.assertTrue(this.userService.userExists(user.getUserId()));
    }

    @Test
    @DisplayName("TestingUserExistsMethodWithParamLongUserIdReturnsFalse")
    public void UserExistsMethodWithParamLongUserIdReturnsFalse(){
        when(this.userRepository.findByUserId(anyLong())).thenReturn(Optional.empty());
        Assertions.assertFalse(this.userService.userExists(anyLong()));
    }

    @Test
    @DisplayName("TestingUserCreatedMethodWithParamUserRequestDtoReturnsLongUserId")
    public void CreateUserMethodWithParamUserRequestDtoReturnsLongUserId(){
        User user= new User(100L,"dharmesh", "d@gmail.com","dx123456", "ROLE_USER");
        when(this.userRepository.save(any())).thenReturn(user);
        when(this.passwordEncoder.encode(anyString())).thenReturn("encrypted"+user.getPassword());
        Assertions.assertEquals(user.getUserId(), this.userService.createUser(new UserRequestDto(user.getUsername(), user.getEmail(), user.getPassword())));
    }

    @Test
    @DisplayName("TestingUserCreatedMethodWithParamUserRequestDtoThrowsUserAlreadyExistsException")
    public void CreateUserMethodWithParamUserRequestDtoThrowsUserAlreadyExistsException(){
        when(this.userRepository.findByUsername(anyString())).thenReturn(Optional.of(new User()));
        var userDto = new UserRequestDto("dharmesh", "d@gmail.com", "dx");
        Exception ex = Assertions.assertThrows(UserAlreadyExistsException.class, () -> this.userService.createUser(userDto));
        Assertions.assertEquals(String.format("User already exists with username: %s", userDto.username()), ex.getMessage());

    }

    @Test
    @DisplayName("TestingGetUserByUserIdMethodWithParamLongUserIdReturnsUserResponseDto")
    public void GetUserByUserIdMethodWithParamLongUserIdReturnsUserResponseDto(){
        User user= new User(100L,"dharmesh", "d@gmail.com", "dx123", "ROLE_USER");
        when(this.userRepository.findById(100L)).thenReturn(Optional.of(user));
        Assertions.assertNotNull(this.userService.getUserByUserId(100L));
    }

    @Test
    @DisplayName("TestingGetUserByUserIdMethodWithParamLongUserIdThrowsUserNotFoundException")
    public void GetUserByUserIdMethodWithParamLongUserIdThrowsUserNotFoundException(){
        when(this.userRepository.findById(100L)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> this.userService.getUserByUserId(100L));
    }

    @Test
    @DisplayName("TestingDeleteUserMethodWithParamLongUserIdShouldReturnTrue")
    public void DeleteUserByUserIdWithParamUserIdShouldReturnTrue(){
        User user= new User(100L,"dharmesh", "d@gmail.com", "dx123", "ROLE_USER");
        when(this.userRepository.findByUserId(100L)).thenReturn(Optional.of(user));
        Assertions.assertTrue(this.userService.deleteUserByUserId(100L));
    }

    @Test
    @DisplayName("TestingDeleteUserMethodWithParamLongUserIdShouldThrowUserNotFoundException")
    public void DeleteUserByUserIdWithParamUserIdShouldThrowUserNotFoundException(){
        when(this.userRepository.findById(100L)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> this.userService.getUserByUserId(100L));
    }
}
