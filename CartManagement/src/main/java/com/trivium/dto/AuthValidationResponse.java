package com.trivium.dto;

public class AuthValidationResponse {
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private Long userId;
    private String username;
    private String role;
    private boolean valid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public AuthValidationResponse(Long userId, String username, String role, boolean valid) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.valid = valid;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public AuthValidationResponse(String username, String role, boolean valid) {
		super();
		this.username = username;
		this.role = role;
		this.valid = valid;
	}
	public AuthValidationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
