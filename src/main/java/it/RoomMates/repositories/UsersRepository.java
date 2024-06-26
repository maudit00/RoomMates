package it.RoomMates.repositories;

import it.RoomMates.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, PagingAndSortingRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
