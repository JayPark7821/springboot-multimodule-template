package kr.jay.core.exception;

/**
 * ErrorCodes
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
public enum ErrorCodes {
	MALFORMED_INPUT(1L),
	GENERAL_HTTP_EXCEPTION(2L),

	UNHANDLED_EXCEPTION(3L),
	;
	private final Long code;

	public Long getCode() {
		return code;
	}

	ErrorCodes(final Long code) {
		this.code = code;
	}
}
