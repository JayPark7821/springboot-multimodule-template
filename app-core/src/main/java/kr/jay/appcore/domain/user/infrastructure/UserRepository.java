package kr.jay.appcore.domain.user.infrastructure;

import java.util.Optional;

import kr.jay.appcore.domain.user.User;

/**
 * UserRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public interface UserRepository {
	void deleteById(final Long userId);

	void save(final User user);

	Optional<User> findByNickName(String nickName);

	Optional<User> findByEmail(String email);
}
