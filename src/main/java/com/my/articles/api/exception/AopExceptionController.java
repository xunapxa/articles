package com.my.articles.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // exception 발생 시 처리해줌
public class AopExceptionController {
    @ExceptionHandler(BadRequestException.class) // 어떤 exception 이 걸리는지 명시
    public ResponseEntity<ApiResponse> badRequestError(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.builder()
                        .message(e.getMessage())
                        .build());
    }
}
