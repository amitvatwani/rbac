package com.virtusa.rbac.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class LoginResponseDto {
    String username;
    String password;
    List<String> authorities;
}
