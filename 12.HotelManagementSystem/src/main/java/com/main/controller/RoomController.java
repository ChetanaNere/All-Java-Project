package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.main.model.Room;
import com.main.model.User;
import com.main.service.RoomService;

@RestController
//@RequestMapping("/api/rooms")
@CrossOrigin("*")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/getAllRooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/saveRooms")
    public Room saveRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }
    
//    @GetMapping("/getRoomByType/{type}")
//    public ResponseEntity<Room> getRoomByType(@PathVariable String type) {
//    	Room room = roomService.getRoomByType(type);
//        return new ResponseEntity<Room>(room,HttpStatus.OK) ;
//    }
}