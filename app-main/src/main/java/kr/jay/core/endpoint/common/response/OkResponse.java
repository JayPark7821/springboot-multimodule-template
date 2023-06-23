package kr.jay.core.endpoint.common.response;

/**
 * OkResponse
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */
public class OkResponse<T> extends Response<T> {

	private final T body;

	public OkResponse(final T body) {
		super(Type.OK);
		this.body = body;
	}

	@Override
	public T getBody() {
		return body;
	}
}
