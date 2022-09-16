package study.petshop.dto;

import lombok.Builder;
import lombok.Data;
import study.petshop.Entity.Member;

@Data
@Builder // 생성자 자동 생성
public class PetDto {

    private Long pet_id;
    private String pet_name;
    private Integer pet_old;
    private Member member_id;


    public PetDto(Long pet_id, String pet_name, Integer pet_old, Member member_id) {
        this.pet_id = pet_id;
        this.pet_name = pet_name;
        this.pet_old = pet_old;
        this.member_id = member_id;
    }
}
