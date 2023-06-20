package kr.jay.appcore.mock;

import kr.jay.appcommon.model.user.OAuthProvider;
import kr.jay.appcore.domain.user.infrastructure.IdTokenVerifier;

/**
 * FakeIdTokenVerifier
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public class FakeIdTokenVerifier implements IdTokenVerifier {

	@Override
	public OAuthInfo verify(final OAuthProvider oAuthProvider, final String idToken) {
		if (oAuthProvider == OAuthProvider.GOOGLE && idToken.equals("google-correct-idToken")) {
			return new OAuthInfo(
				"google-providerId",
				"user-email@gmail.com",
				"test user",
				"profile image url",
				OAuthProvider.GOOGLE
			);
		}
		return null;
	}
}
