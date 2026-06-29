package com.Userver.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Userver.Repository.UserRepository;
import com.Userver.dto.LoginRequestDto;
import com.Userver.dto.LoginResponseDto;
import com.Userver.dto.UserRequestDto;
import com.Userver.dto.UserResponseDto;
import com.Userver.entity.User;
import com.Userver.exception.UserNotFoundException;
import com.Userver.security.JwtUtil;
@Service
public class UserServiceIMPL implements UserService {
	@Autowired
	private UserRepository userRepo;
@Autowired
	private PasswordEncoder passwordencoder;

    @Autowired
    private JwtUtil jwtUtil;

	@Override
	public List<User> getallUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getuserbyid(Long id) {
		return userRepo.findById(id).orElseThrow(()->
		new UserNotFoundException("user not found with id :"+id));
	}

	@Override
	public UserResponseDto saveuser(UserRequestDto dto) {
		
		User user = new User();
		 user.setFirstName(dto.getFirstname());
		 user.setLastName(dto.getLastName());
		 user.setEmail(dto.getEmail());
		 user.setPassword(passwordencoder.encode(dto.getPassword()));
		 user.setRole(dto.getRole());
		 User saveduser = userRepo.save(user);
		 
		 UserResponseDto response = new UserResponseDto();
		 response.setUserId(saveduser.getUserId());
		 response.setFirstName(saveduser.getFirstName());
		 response.setLastName(saveduser.getLastName());
		 response.setEmail(saveduser.getEmail());
		 response.setRole(saveduser.getRole());
		 
		return response;
	}

	@Override
	public LoginResponseDto login(LoginRequestDto request) {
		System.out.println("Email = " + request.getEmail());
		System.out.println("Password = " + request.getPassword());
		User user=	userRepo.findByEmail(request.getEmail())
				.orElseThrow(()->new RuntimeException("user not found"));
			
			    boolean password = passwordencoder.matches(request.getPassword(), user.getPassword());
			    if (!password) {
					throw new RuntimeException("invalid password");
				}
			    String token = jwtUtil.generateToken(user.getEmail());
				return new LoginResponseDto("login success", token);
				
		
	}
	
	
		
	}


