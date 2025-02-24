package ru.tbank.itemsdeliverydemo.common.handling

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ru.tbank.itemsdeliverydemo.common.ErrorResponse

@RestControllerAdvice
@Suppress("UnusedParameter")
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun handleGlobalException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse("Internal Server Error: ${ex.message}"),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}

@RestControllerAdvice
@Suppress("UnusedParameter")
@ConditionalOnMissingBean(ResponseEntityExceptionHandler::class)
class MethodArgumentNotValidExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val errors = ex.bindingResult.fieldErrors
            .map { "${it.field}: ${it.defaultMessage}" }

        val msg = "Validation failed" + errors.joinToString(", ")

        return ResponseEntity(ErrorResponse(msg), HttpStatus.BAD_REQUEST)
    }
}
