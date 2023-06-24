package kr.jay.core.errorhandler;

import java.util.AbstractMap;

import org.springframework.http.HttpStatus;

import jakarta.servlet.http.HttpServletRequest;
import kr.jay.core.exception.ApplicationException;

public interface ExceptionHandlerContract<T extends Exception> {
	AbstractMap.SimpleEntry<ApplicationException, HttpStatus> onException(HttpServletRequest req, T exception);
}