package com.servlet.dto;

//{
/*      "message":"Ahaha",
       "result":120,
       "num":5
*///}
public class AppResponse {
	private String message;
	private int result;
	private int num;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "AppResponse [message=" + message + ", result=" + result + ", num=" + num + "]";
	}

}
