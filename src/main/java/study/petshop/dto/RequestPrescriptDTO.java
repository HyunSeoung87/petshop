package study.petshop.dto;

import lombok.Builder;
import lombok.Data;
import study.petshop.Entity.Pet;
import study.petshop.Entity.Treatment;

@Data
@Builder
public class RequestPrescriptDTO {
    private Treatment treatment;
    private Pet pet;

    public RequestPrescriptDTO(Treatment treatment, Pet pet) {
        this.treatment = treatment;
        this.pet = pet;
    }
}
