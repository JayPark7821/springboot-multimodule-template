package kr.jay.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfig
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private static final int LOG_PAYLOAD_MAX_LENGTH = 4096;

	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(LOG_PAYLOAD_MAX_LENGTH);
		filter.setIncludeHeaders(true);
		filter.setAfterMessagePrefix("REQUEST DATA : ");
		return filter;
	}
}
