package kr.jay.appcore.domain.user;

import java.time.LocalDateTime;

/**
 * User
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public record User(
	Long id,
	String name,
	String email,
	LocalDateTime lastLoginAt,
	LocalDateTime createdAt,
	LocalDateTime lastModifiedAt
) {
}
