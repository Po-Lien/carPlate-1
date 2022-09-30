package idv.cpl.springboot.exception;

public class SessionNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    protected String message;

    public SessionNotFoundException() {
        this.setMessage("Session is not found!");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
