package com.lykeon.StudyLink.exceptions;

public class UsernameAlreadyExistException extends RuntimeException {

    public UsernameAlreadyExistException(String usernameAlreadyExist) {
        super(usernameAlreadyExist);
    }
	
}
