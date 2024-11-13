package com.lykeon.StudyLink.exceptions;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(String emailAlreadyExist) {
        super(emailAlreadyExist);
    }
    
}
