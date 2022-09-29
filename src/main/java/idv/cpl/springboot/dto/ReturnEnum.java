package idv.cpl.springboot.dto;

public enum ReturnEnum {
	SUCCESS(Integer.valueOf(0), ""),
	SUCCESS_INSERT(Integer.valueOf(0), "新增記錄完成"),
	SUCCESS_UPDATE(Integer.valueOf(0), "更新記錄完成"),
	SUCCESS_DELETE(Integer.valueOf(0), "刪除記錄完成"),
	SUCCESS_QUERY(Integer.valueOf(0), "查詢記錄完成"),
	ERROR(Integer.valueOf(-1), "發生錯誤!"),
	DATA_NOT_FOUND(Integer.valueOf(-2), "查無資料!"),
	ERROR_SERVICE(Integer.valueOf(-3), "服務錯誤!"),
	ERROR_INSERT(Integer.valueOf(-11), "新增記錄失敗!"),
	ERROR_UPDATE(Integer.valueOf(-12), "更新記錄失敗!"),
	ERROR_DELETE(Integer.valueOf(-13), "刪除記錄失敗!"),
	ERROR_QUERY(Integer.valueOf(-14), "查詢紀錄失敗!"),
	ERROR_INPUT(Integer.valueOf(-15), "輸入參數錯誤!"),
	HTTP_OK(Integer.valueOf(200), "請求成功。"),
	BAD_REQUEST(Integer.valueOf(400), "請求錯誤。"),
	UN_LOGIN(Integer.valueOf(403), "未登錄"),
	NOT_FOUND(Integer.valueOf(404), "請求失敗。"),
	SERVER_ERROR(Integer.valueOf(500), "請求伺服器失敗。");

	private Integer code;

	private String message;

	private ReturnEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
