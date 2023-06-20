package kr.jay.appcore.small.domain.user;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.jay.appcommon.model.user.OAuthProvider;
import kr.jay.appcore.domain.user.User;
import kr.jay.appcore.domain.user.infrastructure.UserRepository;
import kr.jay.appcore.domain.user.service.JoinUserUseCaseImpl;
import kr.jay.appcore.domain.user.usecase.JoinUserUseCase;
import kr.jay.appcore.mock.FakeIdTokenVerifier;
import kr.jay.appcore.mock.FakeUserRepository;

/**
 * JoinUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @date 2023/06/20
 */
public class JoinUserUseCaseImplTest {
	private JoinUserUseCaseImpl sut;
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		userRepository = new FakeUserRepository();
		sut = new JoinUserUseCaseImpl(userRepository, new FakeIdTokenVerifier());
	}

	@Test
	void JoinUserUseCase의_Query를_이용하여_정상적으로_회원가입_할_수_있다() throws Exception{
	    //given
		final String nickName = "test-nickName";
		JoinUserUseCase.Query query =
			new JoinUserUseCase.Query("google-correct-idToken", nickName, OAuthProvider.GOOGLE);

	    //when
		sut.command(query);

	    //then
		final User user = userRepository.findByNickName(nickName).get();
		assertThat(user.id()).isEqualTo(1L);
		assertThat(user.providerId()).isEqualTo("google-providerId");
		assertThat(user.email()).isEqualTo("user-email@gmail.com");
		assertThat(user.nickName()).isEqualTo(nickName);
		assertThat(user.picture()).isEqualTo("profile image url");
		assertThat(user.provider()).isEqualTo(OAuthProvider.GOOGLE);
		assertThat(user.lastLoginAt()).isNull();
	}
}
