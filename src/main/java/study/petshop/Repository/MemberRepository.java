package study.petshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.petshop.Entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
