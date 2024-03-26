package it.RoomMates.requests;

import it.RoomMates.enums.PropStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProposalRequest {
    @NotNull(message = "Description can't be null")
    private String description;
    @NotNull(message = "Status can't be null")
    private PropStatus status;
    @NotNull(message = "Proposal can't be saved without an user id")
    private int idUser;
}
