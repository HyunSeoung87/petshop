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
    private Long treat_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet_id;

    private boolean using = false; // 치료 유무

    @OneToOne
    @JoinColumn(name = "id")
    private Prescript prescript_id;

}
