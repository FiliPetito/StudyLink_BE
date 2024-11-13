package com.lykeon.StudyLink.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
    private long userId;
    private String username;
    private String password;
    private String email;
    private String firstName;
	private String lastName;
	private String gender;
	private LocalDateTime birthday;
    
	public UserDto() {
		super();
	}
	
	public UserDto(long userId, String username, String password, String email, String firstName, String lastName,
			String gender, LocalDateTime birthday) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", birthday="
				+ birthday + "]";
	}
}
