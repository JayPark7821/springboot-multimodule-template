package kr.jay.core.exception;

/**
 * ExternalException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/24
 */
public class ExternalException extends ApplicationException {

	public ExternalException(final ErrorCodes codeBook, final String message) {
		super(codeBook, message, null);
	}

	public ExternalException(final ErrorCodes codeBook, final String message, final Throwable cause) {
		super(codeBook, message, cause);
	}
}
