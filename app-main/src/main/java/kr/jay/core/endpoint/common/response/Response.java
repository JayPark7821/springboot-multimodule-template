package kr.jay.core.endpoint.common.response;

import java.time.Instant;

/**
 * SimpleResponse
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/21
 */
public abstract class Response<T> {

	private final Type type;
	private final Instant timestamp = Instant.now();

	public abstract T getBody();

	public Response(final Type type) {
		this.type = type;
	}

	public static <T> OkResponse<T> ok(final T payload) {
		return new OkResponse<>(payload);
	}

	public enum Type {
		OK,
		ERROR
	}
}
