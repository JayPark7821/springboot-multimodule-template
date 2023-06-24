package kr.jay.core.exception;

import org.springframework.http.HttpStatus;

/**
 * GeneralHttpException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
public class GeneralHttpException extends ExternalException {
	private final HttpStatus statusCode;

	public GeneralHttpException(HttpStatus statusCode, String message, Throwable cause) {
		super(ErrorCodes.GENERAL_HTTP_EXCEPTION,
			message.isEmpty() ?
				String.format("An unhandled HTTP exception(status = %d) is occurred.", statusCode.value()) :
				message,
			cause);
		this.statusCode = statusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}
}