package study.petshop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.petshop.Entity.Prescript;

@Repository
public interface PrescriptRepository extends JpaRepository<Prescript,Long> {
}
