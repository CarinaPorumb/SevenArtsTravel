package ro.project.exception;

public class TokenNotFound extends Exception {
    public TokenNotFound() {
        super("Token not found!");
    }
}