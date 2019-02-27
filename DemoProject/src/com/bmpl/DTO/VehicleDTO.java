package com.bmpl.DTO;

public class VehicleDTO {
	
	private String name;
	private String staffNo;
	private String type;
	private String vehicleNo;
	private String stickerNo;
	private String supportingDoc;
	private String contactNo;
	private String signature;
	
	
	
	public VehicleDTO() {
		
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStaffNo() {
		return staffNo;
	}



	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getVehicleNo() {
		return vehicleNo;
	}



	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}



	public String getStickerNo() {
		return stickerNo;
	}



	public void setStickerNo(String stickerNo) {
		this.stickerNo = stickerNo;
	}



	public String getSupportingDoc() {
		return supportingDoc;
	}



	public void setSupportingDoc(String supportingDoc) {
		this.supportingDoc = supportingDoc;
	}



	public String getContactNo() {
		return contactNo;
	}



	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public String getSignature() {
		return signature;
	}



	public void setSignature(String signature) {
		this.signature = signature;
	}



	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", staffNo=" + staffNo + ", type=" + type + ", vehicleNo=" + vehicleNo
				+ ", stickerNo=" + stickerNo + ", supportingDoc=" + supportingDoc + ", contactNo=" + contactNo
				+ ", signature=" + signature + "]";
	}
	

}
