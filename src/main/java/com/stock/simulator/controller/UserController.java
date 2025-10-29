package com.stock.simulator.controller;

import com.stock.simulator.dto.AuthRequest;
import com.stock.simulator.dto.AuthResponse;
import com.stock.simulator.entity.User;
import com.stock.simulator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = userService.login(request.getEmail(), request.getPassword());
        return new AuthResponse("Bearer "+token);
    }
}

