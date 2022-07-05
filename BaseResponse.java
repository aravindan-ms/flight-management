package com.example.user.entity;

public class BaseResponse {
Boolean status;
public BaseResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public BaseResponse(Boolean status, String message) {
	super();
	this.status = status;
	this.message = message;
}
String message;
@Override
public String toString() {
	return "BaseResponse [status=" + status + ", message=" + message + "]";
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}