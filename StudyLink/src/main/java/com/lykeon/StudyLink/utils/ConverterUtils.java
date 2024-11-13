package com.lykeon.StudyLink.utils;

import com.lykeon.StudyLink.dtos.UserDto;
import com.lykeon.StudyLink.entities.User;
import com.lykeon.StudyLink.request.RegistrationRequest;

public final class ConverterUtils {

	public static User convertUserDtoToUser (UserDto userDto) {
		
		User user = new User();
		
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setGender(userDto.getGender());
		user.setBirthday(userDto.getBirthday());

		return user;
	}

	public static UserDto convertRegistrationRequestToUserDto(RegistrationRequest registrationRequest) {
		
		UserDto userDto = new UserDto();
		
		userDto.setUsername(registrationRequest.getUsername()); 
		userDto.setPassword(registrationRequest.getPassword());
		userDto.setEmail(registrationRequest.getEmail());
		userDto.setFirstName(registrationRequest.getFirstName());
		userDto.setLastName(registrationRequest.getLastName());
		userDto.setGender(registrationRequest.getGender());
		userDto.setBirthday(registrationRequest.getBirthday().atStartOfDay());

		return userDto;
	}
	
}
