package com.spring.hotelspace.client.register.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ClientRegisterVO {
	 private String clientId;
	 private String clientPassword;
	 private String clientName;
	 private String clientTel;
	 private String clientEmail;
	 private String clientBirth;
	 private Date clientRegDate;
	 private Integer clinetMilage;
	 private Integer clinetState;
	 
	 
	 public ClientRegisterVO() {}
	 
	public ClientRegisterVO(String clientId, String clientPassword, String clientName, String clientTel, String clientEmail,
			String clientBirth, Date clientRegDate, Integer clinetMilage, Integer clinetState) {
		super();
		this.clientId = clientId;
		this.clientPassword = clientPassword;
		this.clientName = clientName;
		this.clientTel = clientTel;
		this.clientEmail = clientEmail;
		this.clientBirth = clientBirth;
		this.clientRegDate = clientRegDate;
		this.clinetMilage = clinetMilage;
		this.clinetState = clinetState;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	

	public String getClientTel() {
		return clientTel;
	}
	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientBirth() {
		return clientBirth;
	}
	public void setClientBirth(String clientBirth) {
		this.clientBirth = clientBirth;
	}
	public Date getClientRegDate() {
		return clientRegDate;
	}
	public void setClientRegDate(Date clientRegDate) {
		this.clientRegDate = clientRegDate;
	}
	public int getClinetMilage() {
		return clinetMilage;
	}
	public void setClinetMilage(Integer clinetMilage) {
		this.clinetMilage = clinetMilage;
	}
	public int getClinetState() {
		return clinetState;
	}
	public void setClinetState(Integer clinetState) {
		this.clinetState = clinetState;
	}
	@Override
	public String toString() {
		return "ClientRegisterVO [clientId=" + clientId + ", clientPassword=" + clientPassword + ", clientName="
				+ clientName + ", clientTel=" + clientTel + ", clientEmail=" + clientEmail + ", clientBirth="
				+ clientBirth + ", clientRegDate=" + clientRegDate + ", clinetMilage=" + clinetMilage + ", clinetState="
				+ clinetState + "]";
	}
}
