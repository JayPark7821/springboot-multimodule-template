package kr.jay.appcore.domain.user.infrastructure;

import kr.jay.appcommon.model.user.OAuthProvider;

/**
 * VerifyIdTokenService
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public interface VerifyIdTokenService {

	OAuthInfo verify( final OAuthProvider oAuthProvider, final String idToken);

	record OAuthInfo(
		String providerId,
		String email,
		String name,
		String picture,
		OAuthProvider provider
	) {
	}
}
