package kr.jay.appcore.domain.user.exception;

/**
 * SameNicknameUserAlreadyExistException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public class SameNicknameUserAlreadyExistException extends RuntimeException	{
	private static final String MESSAGE_FORMAT = "이미 사용중인 NickName입니다. nickName: %s";

	public SameNicknameUserAlreadyExistException(final String nickName) {
		super(String.format(MESSAGE_FORMAT, nickName));
	}

}
