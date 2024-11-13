package com.lykeon.StudyLink.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RegistrationRequest {
	
	private String firstName;
	private String lastName;
	private String gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate birthday;
	private String username;
	private String email;
	private String password;
	
	public RegistrationRequest() {
		super();
	}

	public RegistrationRequest(String firstName, String lastName, String gender, LocalDate birthday, String username,
			String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
		this.username = username;
		this.email = email;
		this.password = password;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", birthday=" + birthday + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}
