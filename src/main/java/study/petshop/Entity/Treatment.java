package study.petshop.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomNum;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet_id;

}
