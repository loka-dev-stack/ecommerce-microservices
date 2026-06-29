package com.Userver.Services;

import java.util.List;

import com.Userver.dto.LoginRequestDto;
import com.Userver.dto.LoginResponseDto;
import com.Userver.dto.UserRequestDto;
import com.Userver.dto.UserResponseDto;
import com.Userver.entity.User;

public interface UserService {
	
	public UserResponseDto saveuser(UserRequestDto user);
	public List<User> getallUsers();
	public User getuserbyid(Long id);
	
	LoginResponseDto login(LoginRequestDto request);

}
