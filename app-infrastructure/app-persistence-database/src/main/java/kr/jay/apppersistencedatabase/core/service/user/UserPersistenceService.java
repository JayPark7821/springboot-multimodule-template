package kr.jay.apppersistencedatabase.core.service.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.jay.appcore.domain.user.entity.User;
import kr.jay.appcore.domain.user.infrastructure.UserCommand;
import kr.jay.appcore.domain.user.infrastructure.UserQuery;
import kr.jay.apppersistencedatabase.core.entity.user.UserEntity;
import kr.jay.apppersistencedatabase.core.repository.user.UserEntityRepository;

/**
 * UserPersistenceService
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */

@Service
public class UserPersistenceService implements UserCommand, UserQuery {

	private final UserEntityRepository repository;

	public UserPersistenceService(final UserEntityRepository repository) {
		this.repository = repository;
	}

	@Override
	public void deleteById(final User user) {

	}

	@Override
	public User save(final User user) {
		return repository.save(UserEntity.fromModel(user))
			.toModel();
	}

	@Override
	public Optional<User> findByNickName(final String nickName) {
		return Optional.empty();
	}

	@Override
	public Optional<User> findByEmail(final String email) {
		return Optional.empty();
	}
}
