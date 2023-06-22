package kr.jay.core.exception.external;

/**
 * MalformedInputException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/21
 */
public class MalformedInputException extends RuntimeException {

	public MalformedInputException(final String message) {
		super(message);
	}
}
