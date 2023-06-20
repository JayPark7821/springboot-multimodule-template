package kr.jay.appcore.domain.user.usecase;

import kr.jay.appcommon.model.user.OAuthProvider;

/**
 * CreateUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public interface JoinUserUseCase {

	void command(final Query query);

	record Query(
		String idToken,
		String nickName,
		OAuthProvider oAuthProvider
	){
	}
}
