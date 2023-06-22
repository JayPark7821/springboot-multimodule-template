package kr.jay.core.endpoint.v1;

/**
 * ApiPaths
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/21
 */
public class ApiPathV1 {
	public static final String V1 = "/v1";

	public static final String USER = V1 + "/user";
	public static final String USER_ID = USER + "/" + ApiVariableV1.PATH_ID;

}
