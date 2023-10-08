package com.airy.ecom.authorizationservice.controller;


import com.airy.ecom.authorizationservice.dto.UserRequestDto;
import com.airy.ecom.authorizationservice.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class UserController {

    @Autowired
    private final UserRegistrationService userRegistrationService;

    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody UserRequestDto userRequestDto){
        userRegistrationService.registerUser(userRequestDto);
        return ResponseEntity.ok().body("User "+ userRequestDto.getUsername()+" Created Successfully");
    }

    @GetMapping("/test")
    public String publicPage(){
        return "This is A Public Page!!";
    }
}
