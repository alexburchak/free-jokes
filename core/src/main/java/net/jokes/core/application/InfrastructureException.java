package net.jokes.core.application;

public class InfrastructureException extends RuntimeException {
    private static final long serialVersionUID = -5491832640570696088L;

    public InfrastructureException(String message) {
        super(message);
    }

    public InfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }
}
