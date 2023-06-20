package kr.jay.appcore.domain.user.service;

import org.springframework.stereotype.Service;

import kr.jay.appcore.domain.user.User;
import kr.jay.appcore.domain.user.exception.AlreadyJoinedUserException;
import kr.jay.appcore.domain.user.exception.SameNicknameUserAlreadyExistException;
import kr.jay.appcore.domain.user.infrastructure.UserRepository;
import kr.jay.appcore.domain.user.infrastructure.IdTokenVerifier;
import kr.jay.appcore.domain.user.usecase.JoinUserUseCase;

/**
 * JoinUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
@Service
public class JoinUserUseCaseImpl implements JoinUserUseCase {

	private final UserRepository userRepository;
	private final IdTokenVerifier idTokenVerifier;

	public JoinUserUseCaseImpl(
		final UserRepository userRepository,
		final IdTokenVerifier idTokenVerifier
	) {
		this.userRepository = userRepository;
		this.idTokenVerifier = idTokenVerifier;
	}

	@Override
	public void command(final Query query) {
		final IdTokenVerifier.OAuthInfo oAuthInfo =
			idTokenVerifier.verify(query.oAuthProvider(), query.idToken());

		if (userRepository.findByEmail(oAuthInfo.email()).isPresent()) {
			throw new AlreadyJoinedUserException(oAuthInfo.email());
		}

		if (userRepository.findByNickName(query.nickName()).isPresent()) {
			throw new SameNicknameUserAlreadyExistException(query.nickName());
		}

		userRepository.save(
			User.create(
				oAuthInfo.providerId(),
				oAuthInfo.email(),
				oAuthInfo.picture(),
				oAuthInfo.provider(),
				query.nickName()
			)
		);
	}
}
