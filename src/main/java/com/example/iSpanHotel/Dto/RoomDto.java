package com.example.iSpanHotel.Dto;

public class RoomDto {
	private Long id;
	private String roomNum;
	private Integer roomFloor;
	private Short roomStatus;
	private String note;
	private Long roomType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getRoomFloor() {
		return roomFloor;
	}
	public void setRoomFloor(Integer roomFloor) {
		this.roomFloor = roomFloor;
	}
	public Short getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(Short roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getRoomType() {
		return roomType;
	}
	public void setRoomType(Long id) {
		this.roomType = id;
	}
	
}
