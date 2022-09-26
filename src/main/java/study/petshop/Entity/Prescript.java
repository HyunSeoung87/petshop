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

    @OneToOne(mappedBy = "prescript_id", fetch = FetchType.LAZY)
    private Treatment treat_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet_id;

    public Prescript(Treatment treatment_id, Pet pet_id) {
        this.treat_id = treatment_id;
        this.pet_id = pet_id;
    }
}
