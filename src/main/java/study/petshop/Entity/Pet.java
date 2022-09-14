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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY : 기본키 생성을 DB가 함
    // SEQUENCE : 유일한 값을 순서대로 매긴다.
    private Long pet_id;

    private String pet_name;

    private Integer pet_old;

    @ManyToOne(fetch = FetchType.LAZY)
    // Lazy : 지연 로딩 -> 연관된 엔티티를 프록시 객체로 가져와서 DB의 부담을 줄여준다. 같이 가져와야하는 상황이라면 SELECT가 2번 된다.
    // EAGER : 즉시 로딩 -> 연관된 엔티티를 바로 가져온다.
    @JoinColumn(name = "member_id")
    private Member member;
}
