package kr.jay.appcore.domain.user.usecase;

import kr.jay.appcore.domain.user.entity.User;

/**
 * FindUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public interface FindUserUseCase {
	User query(final Long userId);
}
