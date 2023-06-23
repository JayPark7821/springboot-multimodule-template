package kr.jay.core.exception;

/**
 * ErrorCodes
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
public enum ErrorCodes {
	MALFORMED_INPUT(1L);

	private final Long code;

	public Long getCode() {
		return code;
	}

	ErrorCodes(final Long code) {
		this.code = code;
	}
}
