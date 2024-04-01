package it.RoomMates.requests;

import it.RoomMates.enums.PropStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProposalRequest {
    @NotNull(message = "Description can't be null")
    private String description;
    @NotNull(message = "Proposal can't be saved without an user id")
    private int idUser;
    private PropStatus status;
}
