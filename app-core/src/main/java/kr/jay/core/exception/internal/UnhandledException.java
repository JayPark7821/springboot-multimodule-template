package kr.jay.core.exception.internal;

import kr.jay.core.exception.ErrorCodes;
import kr.jay.core.exception.InternalException;

/**
 * UnhandledException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/24
 */
public class UnhandledException extends InternalException {

	public UnhandledException(final ErrorCodes codeBook, final String message) {
		super(codeBook, message);
	}

	public UnhandledException(final ErrorCodes codeBook, final String message, final Throwable cause) {
		super(codeBook, message, cause);
	}
}
