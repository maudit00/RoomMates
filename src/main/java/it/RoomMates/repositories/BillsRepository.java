package it.RoomMates.repositories;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository  extends JpaRepository<Bills, Integer>, PagingAndSortingRepository<Bills, Integer> {
    @Query("SELECT b FROM Bills b where :user MEMBER OF b.users")
    Page<Bills> findByUser(Pageable pageable, Users user);
}
