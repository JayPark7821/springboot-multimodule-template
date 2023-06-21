package kr.jay.appcore.domain.user.infrastructure;

import java.util.Optional;

import kr.jay.appcore.domain.user.entity.User;

/**
 * UserRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public interface UserRepository {
	void deleteById(final User user);

	User save(final User user);

	Optional<User> findByNickName(String nickName);

	Optional<User> findByEmail(String email);
}
