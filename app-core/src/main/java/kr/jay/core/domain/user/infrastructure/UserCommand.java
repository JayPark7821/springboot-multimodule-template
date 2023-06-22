package kr.jay.core.domain.user.infrastructure;

import kr.jay.core.domain.user.entity.User;

/**
 * UserCommand
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */
public interface UserCommand {

	void deleteById(final User user);

	User save(final User user);
}
