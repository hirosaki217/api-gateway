package spring.gateway.app.config;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}