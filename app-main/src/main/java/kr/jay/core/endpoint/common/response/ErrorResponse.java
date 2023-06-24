package kr.jay.core.endpoint.common.response;

import static kr.jay.core.endpoint.common.response.ErrorResponse.*;

/**
 * ErrorResponse
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
public class ErrorResponse extends Response<Body> {

	private final Body body;

	public ErrorResponse(Body body) {
		super(Type.ERROR);
		this.body = body;
	}

	public static ErrorResponse create(String message, String code) {
		return new ErrorResponse(new Body(message, code));
	}

	@Override
	public Body getBody() {
		return body;
	}

	public static class Body {

		private final String message;

		private final String code;

		public Body(final String message, final String code) {
			this.message = message;
			this.code = code;

		}

		public String getMessage() {
			return message;
		}

		public String getCode() {
			return code;
		}

	}
}
