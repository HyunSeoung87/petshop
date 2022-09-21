package study.petshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.petshop.Entity.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
}
