package kr.jay.core.errorhandler;

import java.util.AbstractMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import kr.jay.core.exception.ApplicationException;
import kr.jay.core.exception.ExternalException;

/**
 * ApplicationExceptionHandlerImpl
 *
 * @author jaypark
 * @version 1.0.0
 * @since 2023/06/24
 */
@Component
public class ApplicationExceptionHandlerImpl
	implements ExceptionHandlerContract<ApplicationException>, ErrorCodesToHttpStatusMixin {

	@Override
	public AbstractMap.SimpleEntry<ApplicationException, HttpStatus> onException(
		final HttpServletRequest req,
		final ApplicationException exception
	) {
		if (exception instanceof ExternalException) {
			return onExternalException((ExternalException)exception);
		}
		return null;
	}

	private AbstractMap.SimpleEntry<ApplicationException, HttpStatus> onExternalException(ExternalException exception) {
		return new AbstractMap.SimpleEntry<>(exception, toHttpStatus(exception));
	}

}
