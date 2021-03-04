package com.rbsj.evollo.app.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rbsj.evollo.app.comum.exceptions.EntidadeNaoEncontradaException;
import com.rbsj.evollo.app.comum.exceptions.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleNegocioException(EntidadeNaoEncontradaException ex, WebRequest request){
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), 
				HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request){
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), 
				HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		BindingResult bindingResult = ex.getBindingResult();
		List<ApiError.Field> fields = bindingResult.getFieldErrors().stream()
				.map(fe -> { 
					String message =messageSource.getMessage(fe, LocaleContextHolder.getLocale());
					
					return ApiError.Field.builder()
						.nome(fe.getField())
						.menssagemUsuario(message)
						.build();
				})
				.collect(Collectors.toList());
		
		ApiError apiError = ApiError.builder()
		.dataHora(LocalDateTime.now())
		.mensagem("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente!")
		.fields(fields)
		.build();
		
		return handleExceptionInternal(ex, apiError, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if(body == null) {
			body = ApiError.builder()
					.dataHora(LocalDateTime.now())
					.mensagem(status.getReasonPhrase())
					.build();			
		} else if(body instanceof String) {
			body = ApiError.builder()
					.dataHora(LocalDateTime.now())
					.mensagem((String)body)
					.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
