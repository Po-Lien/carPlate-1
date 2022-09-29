package idv.cpl.springboot.exception;

import idv.cpl.springboot.dto.ReturnEnum;

public class ApiException extends Exception {
	ReturnEnum returnEnum;
	String otherMessage;

	public ApiException() {

	}

	public ApiException(Exception e, String otherMessage) {
		super(e);
		initReturnEnum(e, otherMessage);
	}

	public ApiException(Exception e, ReturnEnum returnEnum) {
		super(e);
		this.returnEnum = returnEnum;
		this.otherMessage = returnEnum.getMessage();
	}

	public ApiException(Exception e, ReturnEnum returnEnum, String otherMessage) {
		super(e);
		this.returnEnum = returnEnum;
		this.otherMessage = otherMessage;
	}

	public ReturnEnum getReturnEnum() {
		return returnEnum;
	}

	public void setReturnEnum(ReturnEnum returnEnum) {
		this.returnEnum = returnEnum;
	}

	public String getOtherMessage() {
		return otherMessage;
	}

	public void setOtherMessage(String otherMessage) {
		this.otherMessage = otherMessage;
	}

	private void initReturnEnum(Exception e, String otherMessage) {
		if (e instanceof ErrorInputException) {
			this.returnEnum = ReturnEnum.ERROR_INPUT;
			this.otherMessage = e.getMessage();
		} else if (e instanceof DataNotFoundException) {
			this.returnEnum = ReturnEnum.DATA_NOT_FOUND;
			this.otherMessage = e.getMessage();
		} else if (e instanceof ServiceException) {
			this.returnEnum = ReturnEnum.ERROR_SERVICE;
			this.otherMessage = e.getMessage();
		} else if (e instanceof SessionNotFoundException) {
			this.returnEnum = ReturnEnum.UN_LOGIN;
			this.otherMessage = e.getMessage();
		} else {
			this.returnEnum = ReturnEnum.ERROR;
			this.otherMessage = e.getMessage();
		}
	}
}
