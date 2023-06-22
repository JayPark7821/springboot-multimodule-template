package kr.jay.core.mock;

import java.util.Optional;

import kr.jay.core.domain.user.infrastructure.IdTokenVerifier;
import kr.jay.core.model.user.OAuthProvider;

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
		} else if (oAuthProvider == OAuthProvider.GOOGLE && idToken.equals("google-joined-idToken")) {
			return Optional.of(new OAuthInfo(
				"google-joined-providerId",
				"jay@gmail.com",
				"joined user",
				"profile image url",
				OAuthProvider.GOOGLE
			));
		}
		return Optional.empty();
	}
}
