package kr.jay.appcore.domain.user;

import java.time.LocalDateTime;

import kr.jay.appcommon.model.user.OAuthProvider;

/**
 * User
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public record User(
	Long id,
	String providerId,
	String name,
	String email,
	String picture,
	OAuthProvider provider,
	LocalDateTime lastLoginAt
) {

	public static User create(
		final String providerId,
		final String email,
		final String picture,
		final OAuthProvider provider,
		final String nickName
	){
		return new User(
			null,
			providerId,
			nickName,
			email,
			picture,
			provider,
			null
		);
	}
}
