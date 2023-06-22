package kr.jay.core.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import kr.jay.core.domain.user.entity.User;
import kr.jay.core.domain.user.infrastructure.UserCommand;
import kr.jay.core.domain.user.infrastructure.UserQuery;

/**
 * FakeUserRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public class FakeUserRepository implements UserCommand, UserQuery {

	private final AtomicLong autoGeneratedId = new AtomicLong(0);
	private final List<User> data = Collections.synchronizedList(new ArrayList<>());

	@Override
	public void deleteById(final User user) {
		data.removeIf(item -> Objects.equals(item.id(), user.id()));
	}

	@Override
	public User save(final User user) {
		if (user.id() == null || user.id() == 0) {
			User savedUser = new User(
				autoGeneratedId.incrementAndGet(),
				user.providerId(),
				user.nickName(),
				user.email(),
				user.picture(),
				user.provider(),
				user.lastLoginAt()
			);
			data.add(savedUser);
			return savedUser;
		} else {
			data.removeIf(item -> Objects.equals(item.id(), user.id()));
			data.add(user);
			return user;
		}
	}

	@Override
	public Optional<User> findByNickName(final String nickName) {
		return data.stream().filter(item -> item.nickName().equals(nickName)).findAny();
	}

	@Override
	public Optional<User> findByEmail(final String email) {
		return data.stream().filter(item -> item.email().equals(email)).findAny();
	}
}