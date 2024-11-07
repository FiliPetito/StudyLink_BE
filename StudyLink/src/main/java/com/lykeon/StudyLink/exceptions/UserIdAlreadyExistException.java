package com.lykeon.StudyLink.exceptions;

public class UserIdAlreadyExistException extends RuntimeException {
    public UserIdAlreadyExistException(String userIdIsAlreadyTaken) {
        super(userIdIsAlreadyTaken);
    }
}
