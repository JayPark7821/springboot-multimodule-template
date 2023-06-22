package kr.jay.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kr.jay.core.Persistence;

@Configuration
@EnableJpaRepositories(
	basePackageClasses = {Persistence.class}
)
public class JpaConfiguration {
}
