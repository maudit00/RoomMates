package it.RoomMates.controller;


import it.RoomMates.entities.Proposals;
import it.RoomMates.requests.ProposalRequest;
import it.RoomMates.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposals")
public class ProposalsController {
    @Autowired
    private ProposalService proposalService;

    @GetMapping
    public Page<Proposals> getAll(Pageable pageable) {return proposalService.getAll(pageable);}

    @GetMapping("/{id}")
    public Proposals getById(@PathVariable int id){return proposalService.getById(id);}

    @PostMapping
    public Proposals save(@RequestBody ProposalRequest proposalRequest){return proposalService.save(proposalRequest);}

    @PutMapping("/{id}")
    public Proposals update(@PathVariable int id, @RequestBody ProposalRequest proposalRequest){ return proposalService.update(id, proposalRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { proposalService.delete(id);}
}
