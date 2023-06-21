package kr.jay.appcore.small.domain.user;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.jay.appcommon.model.user.OAuthProvider;
import kr.jay.appcore.domain.user.entity.User;
import kr.jay.appcore.domain.user.exception.AlreadyJoinedUserException;
import kr.jay.appcore.domain.user.exception.IdTokenIsNotValidException;
import kr.jay.appcore.domain.user.exception.SameNicknameUserAlreadyExistException;
import kr.jay.appcore.domain.user.infrastructure.UserRepository;
import kr.jay.appcore.domain.user.usecase.JoinUserUseCase;
import kr.jay.appcore.domain.user.usecase.impl.JoinUserUseCaseImpl;
import kr.jay.appcore.exception.external.MalformedInputException;
import kr.jay.appcore.mock.FakeIdTokenVerifier;
import kr.jay.appcore.mock.FakeUserRepository;

/**
 * JoinUserUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/20
 */
public class JoinUserUseCaseImplTest {
	private JoinUserUseCaseImpl sut;
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		userRepository = new FakeUserRepository();
		sut = new JoinUserUseCaseImpl(userRepository, new FakeIdTokenVerifier());
		userRepository.save(User.create("testProviderIdJay", "jay@gmail.com", null, OAuthProvider.GOOGLE, "jay"));
	}

	@Test
	void JoinUserUseCase의_Query를_이용하여_정상적으로_회원가입_할_수_있다() throws Exception {
		//given
		final String nickName = "test-nickName";
		JoinUserUseCase.Query query =
			new JoinUserUseCase.Query("google-correct-idToken", nickName, OAuthProvider.GOOGLE);

		//when
		sut.command(query);

		//then
		final Optional<User> selectedUser = userRepository.findByNickName(nickName);
		assertThat(selectedUser).isPresent();
		final User user = selectedUser.get();
		assertThat(user.id()).isNotNull();
		assertThat(user.providerId()).isEqualTo("google-providerId");
		assertThat(user.email()).isEqualTo("user-email@gmail.com");
		assertThat(user.nickName()).isEqualTo(nickName);
		assertThat(user.picture()).isEqualTo("profile image url");
		assertThat(user.provider()).isEqualTo(OAuthProvider.GOOGLE);
		assertThat(user.lastLoginAt()).isNull();
	}

	@Test
	void 잘못된_idToken_으로_회원가입을_요청하면_기대하는응답_exception을_반환한다() throws Exception {
		//given
		final String nickName = "test-nickName";
		JoinUserUseCase.Query query =
			new JoinUserUseCase.Query("unknown-idToken", nickName, OAuthProvider.GOOGLE);

		//when
		//then
		assertThatThrownBy(() -> sut.command(query))
			.isInstanceOf(IdTokenIsNotValidException.class)
			.hasMessage("잘못된 IdToken입니다");
	}

	@Test
	void 이미_가입한_이메일_주소로_회원가입을_요청하면_기대하는응답_exception을_반환한다() throws Exception {
		//given
		final String nickName = "joined-nickName";
		JoinUserUseCase.Query query =
			new JoinUserUseCase.Query("google-joined-idToken", nickName, OAuthProvider.GOOGLE);

		//when
		//then
		assertThatThrownBy(() -> sut.command(query))
			.isInstanceOf(AlreadyJoinedUserException.class)
			.hasMessage(String.format("이미 가입된 사용자입니다. email: %s", "jay@gmail.com"));
	}

	@Test
	void 이미_등록된_nickName_으로_회원가입을_요청하면_기대하는응답_exception을_반환한다() throws Exception {
		//given
		final String nickName = "jay";
		JoinUserUseCase.Query query =
			new JoinUserUseCase.Query("google-correct-idToken", nickName, OAuthProvider.GOOGLE);

		//when
		//then
		assertThatThrownBy(() -> sut.command(query))
			.isInstanceOf(SameNicknameUserAlreadyExistException.class)
			.hasMessage(String.format("이미 사용중인 NickName입니다. nickName: %s", "jay"));
	}

	@Test
	void 잘못된_nickName_으로_회원가입을_요청하면_기대하는응답_exception을_반환한다() throws Exception {
		//given
		final String firstWrongNickName = "j";
		final String secondWrongNickName =
			IntStream.range(0, 65)
				.mapToObj(i -> "a")
				.collect(Collectors.joining());

		JoinUserUseCase.Query firstWrongQuery =
			new JoinUserUseCase.Query("google-correct-idToken", firstWrongNickName, OAuthProvider.GOOGLE);
		JoinUserUseCase.Query secondWrongQuery =
			new JoinUserUseCase.Query("google-correct-idToken", secondWrongNickName, OAuthProvider.GOOGLE);
		JoinUserUseCase.Query thridWrongQuery =
			new JoinUserUseCase.Query("google-correct-idToken", null, OAuthProvider.GOOGLE);

		//when
		//then
		assertThatThrownBy(() -> sut.command(firstWrongQuery))
			.isInstanceOf(MalformedInputException.class)
			.hasMessage("닉네임은 2자 이상 64자 이하로 입력해주세요");
		assertThatThrownBy(() -> sut.command(secondWrongQuery))
			.isInstanceOf(MalformedInputException.class)
			.hasMessage("닉네임은 2자 이상 64자 이하로 입력해주세요");
		assertThatThrownBy(() -> sut.command(thridWrongQuery))
			.isInstanceOf(MalformedInputException.class)
			.hasMessage("닉네임은 2자 이상 64자 이하로 입력해주세요");
	}
}
