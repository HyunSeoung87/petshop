package study.petshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.petshop.Entity.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
}
