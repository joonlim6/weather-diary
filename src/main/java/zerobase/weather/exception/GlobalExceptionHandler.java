package zerobase.weather.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zerobase.weather.dto.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllException(Exception exception) {
        log.error("Internal Server Error handled by GlobalExceptionHandler: ", exception);
        return new ErrorResponse("Internal server error has occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
