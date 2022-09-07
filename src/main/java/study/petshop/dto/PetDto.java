package study.petshop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // 생성자 자동 생성
public class PetDto {

    private Long pet_id;
    private String pet_name;
    private Integer pet_old;
}
