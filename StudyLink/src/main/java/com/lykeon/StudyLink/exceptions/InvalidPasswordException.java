package com.lykeon.StudyLink.exceptions;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String invalidPassword) {
        super(invalidPassword);
    }
	
}
