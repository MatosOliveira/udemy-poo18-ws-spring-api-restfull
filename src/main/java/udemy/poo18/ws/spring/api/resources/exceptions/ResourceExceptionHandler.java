package udemy.poo18.ws.spring.api.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import udemy.poo18.ws.spring.api.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError stError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(stError) ;
	}
	
}
