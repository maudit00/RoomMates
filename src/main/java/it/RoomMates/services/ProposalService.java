package it.RoomMates.services;

import it.RoomMates.entities.Proposals;
import it.RoomMates.enums.PropStatus;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.ProposalsRepository;
import it.RoomMates.requests.ProposalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {
    @Autowired
    private ProposalsRepository proposalsRepository;
    @Autowired
    private UsersService usersService;

    public Proposals getById(int id){ return proposalsRepository.findById(id).orElseThrow(() -> new NotFoundException("Proposal not found!"));};

    public Page<Proposals> getAll(Pageable pageable){
        return proposalsRepository.findAll(pageable);
    }

    public Proposals save(ProposalRequest proposal){
        Proposals p = new Proposals();
        p.setDescription(proposal.getDescription());
        p.setUser(usersService.getById(proposal.getIdUser()));
        p.setStatus(PropStatus.PENDING);
        return proposalsRepository.save(p);
    }

    public Proposals update(int id, ProposalRequest proposal){
        Proposals p = getById(id);
        p.setDescription(proposal.getDescription());
        p.setUser(usersService.getById(proposal.getIdUser()));
        p.setStatus(proposal.getStatus());
        return proposalsRepository.save(p);
    }

    public void delete(int id){
        Proposals p = getById(id);
        proposalsRepository.delete(p);
    }

}
