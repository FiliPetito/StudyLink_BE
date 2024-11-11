package com.lykeon.StudyLink.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.lykeon.StudyLink.controllers.HashMap;
import com.lykeon.StudyLink.controllers.Map;

public class DefaultResponse<T>{

    private String codice;
    private String messaggio;
    private T data;
    
    // Costruttori
    public DefaultResponse(T body, String codice, String messaggio, HttpStatus status) {
    	this.data = body;
        this.codice = codice;
        this.messaggio = messaggio;
    }

    public DefaultResponse(String codice, String messaggio, HttpStatus status) {

        this.codice = codice;
        this.messaggio = messaggio;
    }

    // Getters
    public String getCodice() {
        return codice;
    }

    public String getMessaggio() {
        return messaggio;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
