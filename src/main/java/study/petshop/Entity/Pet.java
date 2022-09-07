package study.petshop.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pet")
@Getter @Setter
@AllArgsConstructor // 생성자 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pet_id;

    private String pet_name;

    private Integer pet_old;
}
