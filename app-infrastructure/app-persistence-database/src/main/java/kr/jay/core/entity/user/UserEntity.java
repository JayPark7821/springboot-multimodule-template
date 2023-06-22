package kr.jay.core.entity.user;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.jay.core.domain.user.entity.User;
import kr.jay.core.model.user.OAuthProvider;

/**
 * User
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/22
 */

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String providerId;
	private String nickName;
	private String email;
	private String picture;
	private OAuthProvider provider;
	private LocalDateTime lastLoginAt;

	protected UserEntity() {
	}

	public UserEntity(
		final Long id,
		final String providerId,
		final String nickName,
		final String email,
		final String picture,
		final OAuthProvider provider,
		final LocalDateTime lastLoginAt
	) {
		this.id = id;
		this.providerId = providerId;
		this.nickName = nickName;
		this.email = email;
		this.picture = picture;
		this.provider = provider;
		this.lastLoginAt = lastLoginAt;
	}

	public static UserEntity fromModel(final User user) {
		return new UserEntity(
			user.id(),
			user.providerId(),
			user.nickName(),
			user.email(),
			user.picture(),
			user.provider(),
			user.lastLoginAt()
		);
	}

	public User toModel() {
		return new User(
			this.id,
			this.providerId,
			this.nickName,
			this.email,
			this.picture,
			this.provider,
			this.lastLoginAt
		);
	}

	public Long getId() {
		return id;
	}

	public String getProviderId() {
		return providerId;
	}

	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}

	public String getPicture() {
		return picture;
	}

	public OAuthProvider getProvider() {
		return provider;
	}

	public LocalDateTime getLastLoginAt() {
		return lastLoginAt;
	}
}
