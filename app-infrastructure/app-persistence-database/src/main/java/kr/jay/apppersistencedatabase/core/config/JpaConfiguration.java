package kr.jay.apppersistencedatabase.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kr.jay.apppersistencedatabase.core.Persistence;

@Configuration
@EnableJpaRepositories(
	basePackageClasses = {Persistence.class}
)
public class JpaConfiguration {
}
