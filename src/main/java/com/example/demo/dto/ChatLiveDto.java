package com.example.demo.dto;





public class ChatLiveDto {
	private int id;
	
	private String username;
	
	private int tunnelid;

	public ChatLiveDto(int i, String string, int j) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTunnelid() {
		return tunnelid;
	}

	public void setTunnelid(int tunnelid) {
		this.tunnelid = tunnelid;
	}
	
	public ChatLiveDto() {
		super();
		
	}
	

}
