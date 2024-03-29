package it.RoomMates.repositories;

import it.RoomMates.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillsRepository  extends JpaRepository<Bills, Integer>, PagingAndSortingRepository<Bills, Integer> {
}
