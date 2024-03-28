package it.RoomMates.repositories;

import it.RoomMates.entities.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Integer>, PagingAndSortingRepository<Shifts, Integer> {
}
