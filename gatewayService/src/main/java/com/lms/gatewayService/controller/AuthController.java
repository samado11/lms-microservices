package com.lms.gatewayService.controller;


import com.lms.gatewayService.dto.AuthRequest;
import com.lms.gatewayService.entity.User;
import com.lms.gatewayService.repository.UserRepository;
import com.lms.gatewayService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        String storedPassword = userRepository.findByEmail(authRequest.getEmail()).get().getPassword();

        if (storedPassword != null && passwordEncoder.matches(authRequest.getPassword(),storedPassword)) {
            return service.generateToken(authRequest.getEmail());
        } else {
           return "Invalid username or password";
        }


    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}