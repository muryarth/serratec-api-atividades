package br.org.serratec.exerciciojpa.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<FieldError> listaFieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> erros = new ArrayList<>();

		/*
		 * Percorre uma lista de objetos do tipo "FieldError" e retorna apenas a
		 * "DefaultMessage"
		 */
		for (FieldError error : listaFieldErrors) {
			System.out.println(error.toString());
			erros.add(error.getField() + ": " + error.getDefaultMessage());
		}

		// Instancia o objeto de erro criado na aplicação
		ErrorResponse erroResposta = new ErrorResponse(status.value(), "Existem Campos Invalidos", LocalDateTime.now(),
				erros);

		// Monta a exception baseado no objeto de erro criado na aplicação
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
