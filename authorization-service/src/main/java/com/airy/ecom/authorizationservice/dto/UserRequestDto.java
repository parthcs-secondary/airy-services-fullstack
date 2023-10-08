package com.airy.ecom.authorizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private int id;

    private String username;

    private String password;

    private String emailId;

    private String mobileNumber;

    private boolean isEnabled;

    private LocalDateTime creationDate;
}
