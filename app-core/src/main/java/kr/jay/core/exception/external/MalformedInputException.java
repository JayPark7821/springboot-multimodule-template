package kr.jay.core.exception.external;

import kr.jay.core.exception.ApplicationException;
import kr.jay.core.exception.ErrorCodes;

/**
 * MalformedInputException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/21
 */
public class MalformedInputException extends ApplicationException {

	public MalformedInputException(final String message) {
		super(ErrorCodes.MALFORMED_INPUT, message);
	}
}
