package study.petshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.petshop.Entity.Pet;
import study.petshop.Entity.Treatment;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {


    Optional<Treatment> getTreatmentsByPet_id(Pet pet_id);
}
