package kr.jay.core.errorhandler;

import org.springframework.http.HttpStatus;

import kr.jay.core.exception.ApplicationException;
import kr.jay.core.exception.ErrorCodes;
import kr.jay.core.exception.GeneralHttpException;

public interface ErrorCodesToHttpStatusMixin {

	default HttpStatus toHttpStatus(ApplicationException exception) {
		if (exception instanceof GeneralHttpException) {
			return ((GeneralHttpException)exception).getStatusCode();
		} else {
			return this.toHttpStatus(exception.getCodeBook());
		}
	}

	default HttpStatus toHttpStatus(ErrorCodes errorCode) {
		return switch (errorCode) {
			// General error cases
			case MALFORMED_INPUT, GENERAL_HTTP_EXCEPTION -> HttpStatus.BAD_REQUEST;

			default -> HttpStatus.INTERNAL_SERVER_ERROR;
		};
	}
}