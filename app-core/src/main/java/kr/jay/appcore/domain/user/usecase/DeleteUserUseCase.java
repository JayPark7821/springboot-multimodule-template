package kr.jay.appcore.domain.user.usecase;

/**
 * DeleteUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public interface DeleteUserUseCase {
	void command(final Long userId);
}

