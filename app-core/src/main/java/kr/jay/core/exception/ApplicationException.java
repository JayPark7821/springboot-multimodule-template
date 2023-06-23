package kr.jay.core.exception;

/**
 * ApplicationException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
public abstract class ApplicationException extends RuntimeException {
	private final ErrorCodes codeBook;

	public ApplicationException(ErrorCodes codeBook, String message) {
		super(message);
		this.codeBook = codeBook;
	}

	public ErrorCodes getCodeBook() {
		return codeBook;
	}

}

