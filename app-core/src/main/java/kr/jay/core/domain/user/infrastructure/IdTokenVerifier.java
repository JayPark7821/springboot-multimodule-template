package kr.jay.core.domain.user.infrastructure;

import java.util.Optional;

import kr.jay.core.model.user.OAuthProvider;

/**
 * VerifyIdTokenService
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public interface IdTokenVerifier {

	Optional<OAuthInfo> verify(final OAuthProvider oAuthProvider, final String idToken);

	record OAuthInfo(
		String providerId,
		String email,
		String name,
		String picture,
		OAuthProvider provider
	) {
	}
}
