package kr.jay.core.advice;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kr.jay.core.endpoint.common.response.Response;

/**
 * ResponseDecorator
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/23
 */
@RestControllerAdvice
public class ResponseDecorator implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(
		final MethodParameter returnType,
		final Class<? extends HttpMessageConverter<?>> converterType
	) {
		final Method method = returnType.getMethod();
		if (method == null) {
			return false;
		}

		return Stream.of(method.getReturnType().getDeclaredAnnotations())
			.anyMatch(annotation -> annotation.annotationType() == JsonSerialize.class);
	}

	@Override
	public Object beforeBodyWrite(
		final Object body,
		final MethodParameter returnType,
		final MediaType selectedContentType,
		final Class<? extends HttpMessageConverter<?>> selectedConverterType,
		final ServerHttpRequest request,
		final ServerHttpResponse response
	) {
		return Response.ok(body);
	}
}
