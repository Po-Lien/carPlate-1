package idv.cpl.springboot.exception;

public class ErrorInputException extends Exception {

	private StringBuffer sbf;
	public ErrorInputException() {
		this.initStringBuffer();
	}

	public ErrorInputException(String message) {
		super(message);
		initStringBuffer();
		this.sbf.append(message);
	}

	public ErrorInputException(String message, Throwable cause) {
		super(message, cause);
		this.initStringBuffer();
		this.sbf.append(message);
	}

	public ErrorInputException(Throwable cause) {
		super(cause);
		this.initStringBuffer();
	}
	
	public void appendMessage(String msg) {
		if (this.sbf.length() > 0) {
			this.sbf.append(System.getProperty("line.separator"));
			this.sbf.append(msg);
		} else {
			this.sbf.append(msg);
		}
	}
	
	private void initStringBuffer() {
		if (this.sbf == null) {
			this.sbf = new StringBuffer();
		}
	}
	
	public String getMessage() {
		return this.sbf.toString();
	}
}
