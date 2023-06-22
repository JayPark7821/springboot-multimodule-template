package kr.jay.appcore.domain.user.infrastructure;

import java.util.Optional;

import kr.jay.appcore.domain.user.entity.User;

/**
 * UserQuery
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */
public interface UserQuery {
	Optional<User> findByNickName(String nickName);

	Optional<User> findByEmail(String email);
}
