package kr.jay.core.domain.user.usecase;

import kr.jay.core.model.user.OAuthProvider;

/**
 * CreateUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public interface JoinUserUseCase {

	void command(final Query query);

	record Query(
		String idToken,
		String nickName,
		OAuthProvider oAuthProvider
	) {
	}
}
