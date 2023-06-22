package kr.jay.core.endpoint.v1;

import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import kr.jay.core.domain.user.entity.User;
import kr.jay.core.endpoint.common.response.Response;
import kr.jay.core.endpoint.common.validation.ValueOfEnum;
import kr.jay.core.model.user.OAuthProvider;

/**
 * JoinUserController
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/21
 */

public interface JoinUserController {

	@PostMapping(ApiPathV1.USER)
	Response<Void> join(final JoinUserRequest request);

	record JoinUserRequest(
		@NotEmpty
		String idToken,

		@Size(min = User.LENGTH_NICK_NAME_MIN, max = User.LENGTH_NICK_NAME_MAX)
		String nickName,

		@ValueOfEnum(enumClass = OAuthProvider.class)
		OAuthProvider oAuthProvider
	) {
	}
}
