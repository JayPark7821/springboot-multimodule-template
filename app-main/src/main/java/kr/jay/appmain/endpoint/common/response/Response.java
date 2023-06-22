package kr.jay.appmain.endpoint.common.response;

import java.time.Instant;

/**
 * SimpleResponse
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/21
 */
public abstract class Response<T> {

	private final Type responseType;
	private final T body;
	private final Instant timestamp = Instant.now();

	public Response(final Type responseType, final T body) {
		this.responseType = responseType;
		this.body = body;
	}

	public enum Type {
		OK,
		ERROR
	}
}
