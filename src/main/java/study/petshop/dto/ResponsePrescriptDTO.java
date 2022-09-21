package study.petshop.dto;

import lombok.Builder;
import lombok.Data;
import study.petshop.Entity.Pet;
import study.petshop.Entity.Treatment;

@Data
@Builder
public class ResponsePrescriptDTO {
    private Long id;
    private Treatment treatment;
    private Pet pet;

    public ResponsePrescriptDTO(Long id, Treatment treatment, Pet pet) {
        this.id = id;
        this.treatment = treatment;
        this.pet = pet;
    }
}
