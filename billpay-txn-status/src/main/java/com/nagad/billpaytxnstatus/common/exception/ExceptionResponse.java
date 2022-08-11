package com.nagad.billpaytxnstatus.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private HttpStatus status;
    private String message;
    private List<String> errors;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
    private LocalDateTime timestamp;
}
