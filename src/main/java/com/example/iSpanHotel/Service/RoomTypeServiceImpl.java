package com.example.iSpanHotel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.RoomTypeDao;
import com.example.iSpanHotel.Dto.RoomTypeDto;
import com.example.iSpanHotel.model.RoomType;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{
	
	@Autowired
	private RoomTypeDao roomTypeDao;
	
	@Override
	public String create(RoomTypeDto roomTypeDto) {
		
		try {
			RoomType roomType = new RoomType();
			roomType.setRoomtype(roomTypeDto.getRoomType());
			roomType.setRoomprice(roomTypeDto.getRoomPrice());
			roomType.setRoompic(roomTypeDto.getRoomPic());
			roomType.setContent(roomTypeDto.getContent());
			roomTypeDao.save(roomType);
			return "房型創建成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
		
	}
}
