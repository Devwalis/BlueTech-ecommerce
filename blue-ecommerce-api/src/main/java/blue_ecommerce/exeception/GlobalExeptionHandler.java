package blue_ecommerce.exeception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {
    

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(), error.getDefaultMessage());
        });
        errors.put("type", "FORM_VALIDATION_ERROR");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);    }

@ExceptionHandler(DataIntegrityViolationException.class)
public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex){
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("message", "Ocorreu um erro interno no servidor");
    errorResponse.put("type", "INTERNAL_ERROR");
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}

@ExceptionHandler(Exception.class)
public ResponseEntity<Map<String, String>> handleGeneralExceptions(Exception ex){
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("message","Ocorreu um erro interno no servidor");
    errorResponse.put("type", "INTERNAL_ERROR");
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}
    

}
