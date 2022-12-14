package study.petshop.dto;

import lombok.Builder;
import lombok.Data;
import study.petshop.Entity.Pet;

@Data
@Builder
public class TreatmentDTO {
    private Long roomNum;
    private Pet pet_id;

    private Boolean using;

    public TreatmentDTO(Long roomNum, Pet pet_id) {
        this.roomNum = roomNum;
        this.pet_id = pet_id;
    }

    public TreatmentDTO(Long roomNum, Pet pet_id, Boolean using) {
        this.roomNum = roomNum;
        this.pet_id = pet_id;
        this.using = using;
    }
}
