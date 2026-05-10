package co.edu.ufps.ingsistemas.analisis_impacto.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
