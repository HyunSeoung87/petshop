package study.petshop.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Prescript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment_id;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet_id;

    public Prescript(Treatment treatment_id, Pet pet_id) {
        this.treatment_id = treatment_id;
        this.pet_id = pet_id;
    }
}
