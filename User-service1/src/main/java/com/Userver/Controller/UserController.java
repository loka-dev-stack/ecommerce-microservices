package com.Userver.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Userver.Services.UserService;
import com.Userver.dto.LoginRequestDto;
import com.Userver.dto.LoginResponseDto;
import com.Userver.dto.UserRequestDto;
import com.Userver.dto.UserResponseDto;
import com.Userver.entity.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService services;
	
	@GetMapping("/")
    public String home() {
        return "User Service Running Successfully";
    }
	
	
	@PostMapping("/register")
	public UserResponseDto registerUser(@Valid @RequestBody UserRequestDto dto) {
	    System.out.println(dto);

		return services.saveuser(dto);
	}
	
	@GetMapping
    public List<User> getAllUsers() {
        return services.getallUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return services.getuserbyid(id);
    }
    
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {
    	
    	return services.login(request) ;
    }
	
	

}
