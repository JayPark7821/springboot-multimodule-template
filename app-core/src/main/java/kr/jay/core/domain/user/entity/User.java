package kr.jay.core.domain.user.entity;

import java.time.LocalDateTime;

import kr.jay.core.exception.external.MalformedInputException;
import kr.jay.core.model.user.OAuthProvider;

/**
 * User
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public record User(
	Long id,
	String providerId,
	String nickName,
	String email,
	String picture,
	OAuthProvider provider,
	LocalDateTime lastLoginAt
) {

	public static final int LENGTH_NICK_NAME_MIN = 2;
	public static final int LENGTH_NICK_NAME_MAX = 64;

	public static User create(
		final String providerId,
		final String email,
		final String picture,
		final OAuthProvider provider,
		final String nickName
	) {
		if (nickName == null ||
			nickName.length() < LENGTH_NICK_NAME_MIN ||
			nickName.length() > LENGTH_NICK_NAME_MAX
		) {
			throw new MalformedInputException("닉네임은 2자 이상 64자 이하로 입력해주세요");
		}
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
