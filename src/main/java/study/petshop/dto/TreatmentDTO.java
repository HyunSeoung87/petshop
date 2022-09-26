package study.petshop.dto;

import lombok.Builder;
import lombok.Data;
import study.petshop.Entity.Pet;

@Data
@Builder
public class TreatmentDTO {
    private Long id;
    private Pet pet_id;

    private Boolean using;

    public TreatmentDTO(Long id, Pet pet_id) {
        this.id = id;
        this.pet_id = pet_id;
    }

    public TreatmentDTO(Long id, Pet pet_id, Boolean using) {
        this.id = id;
        this.pet_id = pet_id;
        this.using = using;
    }
}
