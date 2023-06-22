package kr.jay.core.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import kr.jay.core.domain.user.infrastructure.IdTokenVerifier;
import kr.jay.core.mock.FakeIdTokenVerifier;

@TestConfiguration
public class TestConfig {

	@Primary
	@Bean
	public IdTokenVerifier tokenVerifier() {
		return new FakeIdTokenVerifier();
	}
}
