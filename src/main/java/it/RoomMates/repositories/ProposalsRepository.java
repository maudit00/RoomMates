package it.RoomMates.repositories;

import it.RoomMates.entities.Proposals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalsRepository extends JpaRepository<Proposals, Integer>, PagingAndSortingRepository<Proposals, Integer> {
}
