package kr.jay.core.endpoint.v1.impl;

import static kr.jay.core.endpoint.v1.JoinUserController.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import kr.jay.core.config.TestConfig;
import kr.jay.core.endpoint.v1.ApiPathV1;
import kr.jay.core.model.user.OAuthProvider;

/**
 * JoinUserControllerImplTest
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */

@Import(TestConfig.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JoinUserControllerImplTest {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Test
	void 정상적인_회원가입_요청을_하면_기대하는_응답을_반환한다() throws Exception {
		//given
		final JoinUserRequest request =
			new JoinUserRequest("google-correct-idToken", "test-nickName", OAuthProvider.GOOGLE);

		//when
		//then
		RestAssured.
			given().log().all()
			.contentType(ContentType.JSON)
			.body(request).

			when()
			.post(ApiPathV1.USER).

			then()
			.log().all()
			.statusCode(HttpStatus.OK.value());
	}
}