package kr.jay.appcore.domain.user.usecase.impl;

import static kr.jay.appcore.domain.user.infrastructure.IdTokenVerifier.*;

import org.springframework.stereotype.Service;

import kr.jay.appcore.domain.user.entity.User;
import kr.jay.appcore.domain.user.exception.AlreadyJoinedUserException;
import kr.jay.appcore.domain.user.exception.IdTokenIsNotValidException;
import kr.jay.appcore.domain.user.exception.SameNicknameUserAlreadyExistException;
import kr.jay.appcore.domain.user.infrastructure.IdTokenVerifier;
import kr.jay.appcore.domain.user.infrastructure.UserCommand;
import kr.jay.appcore.domain.user.infrastructure.UserQuery;
import kr.jay.appcore.domain.user.usecase.JoinUserUseCase;

/**
 * JoinUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
@Service
public class JoinUserUseCaseImpl implements JoinUserUseCase {

	private final UserCommand userCommand;
	private final UserQuery userQuery;
	private final IdTokenVerifier idTokenVerifier;

	public JoinUserUseCaseImpl(
		final UserCommand userCommand,
		final UserQuery userQuery,
		final IdTokenVerifier idTokenVerifier
	) {
		this.userCommand = userCommand;
		this.userQuery = userQuery;
		this.idTokenVerifier = idTokenVerifier;
	}

	@Override
	public void command(final Query query) {
		idTokenVerifier.verify(query.oAuthProvider(), query.idToken())
			.ifPresentOrElse(
				oAuthInfo -> createUserAndPersist(query, oAuthInfo),
				() -> {
					throw new IdTokenIsNotValidException();
				}
			);

	}

	private void createUserAndPersist(final Query query, final OAuthInfo oAuthInfo) {

		validateUserInput(query, oAuthInfo);

		userCommand.save(
			User.create(
				oAuthInfo.providerId(),
				oAuthInfo.email(),
				oAuthInfo.picture(),
				oAuthInfo.provider(),
				query.nickName()
			)
		);
	}

	private void validateUserInput(final Query query, final OAuthInfo oAuthInfo) {

		if (userQuery.findByEmail(oAuthInfo.email()).isPresent()) {
			throw new AlreadyJoinedUserException(oAuthInfo.email());
		}

		if (userQuery.findByNickName(query.nickName()).isPresent()) {
			throw new SameNicknameUserAlreadyExistException(query.nickName());
		}
	}
}
