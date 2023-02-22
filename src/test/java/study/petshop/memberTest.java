package study.petshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import study.petshop.Entity.Member;
import study.petshop.Entity.Pet;
import study.petshop.Repository.MemberRepository;
import study.petshop.Repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class memberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PetRepository petRepository;

    @Test
    void test() {
        // test 성공!
    }
}
