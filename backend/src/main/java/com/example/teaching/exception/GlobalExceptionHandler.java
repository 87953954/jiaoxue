package com.example.teaching.exception;

import com.example.teaching.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.teaching.common.ResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;

import java.util.NoSuchElementException;
/**
 * GlobalExceptionHandler class to handle exceptions thrown by the application.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @param e
     * @return {@link Result<String>}
     * @Description handleException
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> handleGlobalException(Exception e) {
        logger.error("An unexpected error occurred", e);
        return ResultUtils.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred: " + e.getMessage());
    }

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @param e
     * @return {@link Result<String>}
     * @Description handleIllegalArgumentException
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error("IllegalArgumentException occurred", e);
        return ResultUtils.error(HttpStatus.BAD_REQUEST.value(), "Invalid argument: " + e.getMessage());
    }
    /**
     * @param e
     * @return {@link Result<String>}
     * @Description handleNoSuchElementException
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<String> handleNoSuchElementException(NoSuchElementException e) {
        logger.error("NoSuchElementException occurred", e);
        return ResultUtils.error(HttpStatus.NOT_FOUND.value(), "Resource not found: " + e.getMessage());
    }



}