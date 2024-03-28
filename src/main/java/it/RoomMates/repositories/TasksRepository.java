package it.RoomMates.repositories;

import it.RoomMates.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer>, PagingAndSortingRepository<Tasks, Integer> {
}
