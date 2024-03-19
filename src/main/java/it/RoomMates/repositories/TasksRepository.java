package it.RoomMates.repositories;

import it.RoomMates.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TasksRepository extends JpaRepository<Tasks, Integer>, PagingAndSortingRepository<Tasks, Integer> {
}
