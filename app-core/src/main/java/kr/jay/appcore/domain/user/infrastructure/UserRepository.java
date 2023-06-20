package kr.jay.appcore.domain.user.infrastructure;

/**
 * UserRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public interface UserRepository {
	void deleteById(final Long userId);
}
