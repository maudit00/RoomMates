package it.RoomMates.repositories;

import it.RoomMates.entities.RoomMate;
import it.RoomMates.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoomMateRepository  extends JpaRepository<RoomMate, Integer>, PagingAndSortingRepository<RoomMate, Integer> {
}
