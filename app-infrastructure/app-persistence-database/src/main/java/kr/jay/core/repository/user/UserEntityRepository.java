package kr.jay.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.jay.core.entity.user.UserEntity;

/**
 * UserEntityRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
