package org.msa.item.org.msa.item.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.msa.item.org.msa.item.dto.ResponseDTO;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //전역적으로 에러 핸들링
public class ApiExceptionHandler {
    //모든 Exception에 대한 데이터 처리를 구현한 로직
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Exception(HttpServletRequest request, Exception e) throws Exception {
        ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();
        responseBuilder.code("500").message(e.getMessage());
        return ResponseEntity.ok(responseBuilder.build());
    }

    //유효성 체크에 대한 Exception에 대한 데이터 처리를 구현한 로직
    //유효성 체크 후 에러가 발생하면 MethodArgumentNotValidException 에러 내용 출력
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) throws JSONException {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");
        }

        ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();
        responseBuilder.code("500").message(builder.toString());
        return ResponseEntity.ok(responseBuilder.build());
    }
}
