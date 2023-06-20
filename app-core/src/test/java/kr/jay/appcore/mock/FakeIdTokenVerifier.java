package kr.jay.appcore.mock;

import java.util.Optional;

import kr.jay.appcommon.model.user.OAuthProvider;
import kr.jay.appcore.domain.user.infrastructure.IdTokenVerifier;

/**
 * FakeIdTokenVerifier
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public class FakeIdTokenVerifier implements IdTokenVerifier {

	@Override
	public Optional<OAuthInfo> verify(final OAuthProvider oAuthProvider, final String idToken) {
		if (oAuthProvider == OAuthProvider.GOOGLE && idToken.equals("google-correct-idToken")) {
			return Optional.of(new OAuthInfo(
				"google-providerId",
				"user-email@gmail.com",
				"test user",
				"profile image url",
				OAuthProvider.GOOGLE
			));
		}
		return Optional.empty();
	}
}
