package it.RoomMates.repositories;

import it.RoomMates.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>, PagingAndSortingRepository<Users, Integer> {
}
