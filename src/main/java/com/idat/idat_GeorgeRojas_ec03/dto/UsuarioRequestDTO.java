package com.idat.idat_GeorgeRojas_ec03.dto;


public class UsuarioRequestDTO {
	
	private Integer idRequest;
	private String usuarioRequest;
	private String passwordRequest;
	private String rolRequest;
	private Integer idClienteRequest;
	
	public Integer getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}
	public String getUsuarioRequest() {
		return usuarioRequest;
	}
	public void setUsuarioRequest(String usuarioRequest) {
		this.usuarioRequest = usuarioRequest;
	}
	public String getPasswordRequest() {
		return passwordRequest;
	}
	public void setPasswordRequest(String passwordRequest) {
		this.passwordRequest = passwordRequest;
	}
	public String getRolRequest() {
		return rolRequest;
	}
	public void setRolRequest(String rolRequest) {
		this.rolRequest = rolRequest;
	}
	public Integer getIdClienteRequest() {
		return idClienteRequest;
	}
	public void setIdClienteRequest(Integer idClienteRequest) {
		this.idClienteRequest = idClienteRequest;
	}
	
}