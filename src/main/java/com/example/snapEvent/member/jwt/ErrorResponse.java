package com.example.snapEvent.member.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@Builder
public class ErrorResponse {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final String timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorResponse(String timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public static ErrorResponse of(HttpStatus httpStatus, String message, HttpServletRequest request) {
        return ErrorResponse.builder()
                .error(httpStatus.name())
                .message(message)
                .path(request.getServletPath())
                .build();
    }

    //생성자 및 정적 메소드 생략

    public String convertToJson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(this);
    }

}