package study.petshop.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter
@AllArgsConstructor // 생성자 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;
    private String member_name;
    private Integer member_old;

    @OneToMany(mappedBy = "member")
    private List<Pet> my_pet;
}
