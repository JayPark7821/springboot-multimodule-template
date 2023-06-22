package kr.jay.core.endpoint.v1.impl;

import static kr.jay.core.domain.user.usecase.JoinUserUseCase.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.jay.core.domain.user.usecase.JoinUserUseCase;
import kr.jay.core.endpoint.common.response.OkResponse;
import kr.jay.core.endpoint.common.response.Response;
import kr.jay.core.endpoint.v1.JoinUserController;

/**
 * JoinUserControllerImpl
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */
@RestController
public class JoinUserControllerImpl implements JoinUserController {

	private final JoinUserUseCase joinUserUseCase;

	public JoinUserControllerImpl(final JoinUserUseCase joinUserUseCase) {
		this.joinUserUseCase = joinUserUseCase;
	}

	@Override
	public Response<Void> join(@RequestBody final JoinUserRequest request) {
		joinUserUseCase.command(toQuery(request));
		return new OkResponse<>();
	}

	private Query toQuery(final JoinUserRequest request) {
		return new Query(
			request.idToken(),
			request.nickName(),
			request.oAuthProvider()
		);
	}
}
