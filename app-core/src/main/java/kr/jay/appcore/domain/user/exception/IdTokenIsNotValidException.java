package kr.jay.appcore.domain.user.exception;

/**
 * AlreadyJoinedUserException
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public class IdTokenIsNotValidException extends RuntimeException {

	private static final String MESSAGE_FORMAT = "잘못된 IdToken입니다";

	public IdTokenIsNotValidException() {
		super(MESSAGE_FORMAT);
	}
}
