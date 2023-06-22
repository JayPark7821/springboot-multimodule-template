package kr.jay.appmain.endpoint.common.response;

/**
 * OkResponse
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */
public class OkResponse<T> extends Response<T> {

	public OkResponse(final T body) {
		super(Type.OK, body);
	}

	public OkResponse() {
		super(Type.OK, null);
	}
}
