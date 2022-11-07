package spring.gateway.app.model;

import lombok.Data;


public class GatewayResponse {
	private int id = 0;
	private String message = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GatewayResponse(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public GatewayResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GatewayResponse [id=" + id + ", message=" + message + "]";
	}
	
}
