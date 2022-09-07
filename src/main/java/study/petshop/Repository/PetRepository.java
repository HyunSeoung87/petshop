package study.petshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.petshop.Entity.Pet;

public interface PetRepository  extends JpaRepository<Pet, Long> {
}
