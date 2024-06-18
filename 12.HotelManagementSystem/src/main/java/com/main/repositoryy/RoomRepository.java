package com.main.repositoryy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{


//	public Room findByType(type);

	

}
