package study.petshop.dto;

import lombok.Builder;
import lombok.Data;
import study.petshop.Entity.Pet;

import java.util.List;

@Data
@Builder
public class MemberDto {

    private Long member_id;
    private String member_name;
    private Integer member_old;
    private List<Pet> my_pet;
}
