package kr.jay.core.exception;

/**
 * ExternalException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/24
 */
public class InternalException extends ApplicationException {

	public InternalException(final ErrorCodes codeBook, final String message) {
		super(codeBook, message, null);
	}

	public InternalException(final ErrorCodes codeBook, final String message, final Throwable cause) {
		super(codeBook, message, cause);
	}
}
