package com.my.articles.api.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    // 삭제 요청 성공, 실패 시 완료,오류 메세지 실어서 보냄
    String message;
}
