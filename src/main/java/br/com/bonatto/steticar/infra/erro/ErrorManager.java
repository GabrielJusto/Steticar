package br.com.bonatto.steticar.infra.erro;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorManager {


    @SuppressWarnings("rawtypes")
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manage404()
    {
        return ResponseEntity.notFound().build();
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(CadastroException.class)
    public ResponseEntity manageCadastroException(CadastroException e)
    {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manageErroValidacao()
    {
        return ResponseEntity.badRequest().build();
    }

      @SuppressWarnings("rawtypes")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity manageErroMessageNotReadeble()
    {
        return ResponseEntity.badRequest().build();
    }
}

