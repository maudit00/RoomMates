package it.RoomMates.repositories;

import it.RoomMates.entities.Shifts;
import it.RoomMates.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Integer>, PagingAndSortingRepository<Shifts, Integer> {
    @Query("SELECT s FROM Shifts s where :user = s.user")
    Page<Shifts> findByUser(Pageable pageable, Users user );
}
