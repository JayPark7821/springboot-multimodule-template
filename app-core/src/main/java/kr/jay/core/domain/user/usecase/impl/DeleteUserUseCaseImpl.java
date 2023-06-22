package kr.jay.core.domain.user.usecase.impl;

import org.springframework.stereotype.Service;

import kr.jay.core.domain.user.entity.User;
import kr.jay.core.domain.user.infrastructure.UserCommand;
import kr.jay.core.domain.user.usecase.DeleteUserUseCase;

/**
 * DeleteUserUseCaseImpl
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

	private final UserCommand userCommand;

	public DeleteUserUseCaseImpl(final UserCommand userCommand) {
		this.userCommand = userCommand;
	}

	@Override
	public void command(final User user) {
		userCommand.deleteById(user);
	}
}
