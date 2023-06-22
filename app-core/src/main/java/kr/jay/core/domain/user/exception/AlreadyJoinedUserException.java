package kr.jay.core.domain.user.exception;

/**
 * AlreadyJoinedUserException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public class AlreadyJoinedUserException extends RuntimeException {

	private static final String MESSAGE_FORMAT = "이미 가입된 사용자입니다. email: %s";

	public AlreadyJoinedUserException(final String email) {
		super(String.format(MESSAGE_FORMAT, email));
	}
}
