package kr.jay.core.advice;

import java.util.AbstractMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import kr.jay.core.endpoint.common.response.ErrorResponse;
import kr.jay.core.endpoint.common.response.Response;
import kr.jay.core.errorhandler.ExceptionHandlerContract;
import kr.jay.core.exception.ApplicationException;
import kr.jay.core.exception.ErrorCodes;

/**
 * ErrorResponseDecorator
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */

@RestControllerAdvice
public class ErrorResponseDecorator {

	private static final String DEFAULT_ERROR_MESSAGE = "Cannot process this request.";
	private final ExceptionHandlerContract<ApplicationException> applicationExceptionHandler;

	public ErrorResponseDecorator(
		final ExceptionHandlerContract<ApplicationException> applicationExceptionHandler
	) {
		this.applicationExceptionHandler = applicationExceptionHandler;

	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> defaultException(HttpServletRequest request, Exception e) {

		if (e instanceof ApplicationException) {
			return postProcessError(applicationExceptionHandler.onException(request, (ApplicationException)e));
		}
		return null;
	}

	private ResponseEntity<ErrorResponse> postProcessError(
		final AbstractMap.SimpleEntry<ApplicationException, HttpStatus> entry
	) {

		return entry.getKey() == null
			? new ResponseEntity<>(Response.error(DEFAULT_ERROR_MESSAGE, ErrorCodes.UNHANDLED_EXCEPTION.toString()),
			entry.getValue())
			: new ResponseEntity<>(
			Response.error(entry.getKey().getMessage(), entry.getKey().getCodeBook().getCode().toString()),
			entry.getValue());
	}

}
