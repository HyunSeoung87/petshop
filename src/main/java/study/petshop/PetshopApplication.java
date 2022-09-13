package study.petshop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import study.petshop.Entity.Member;
import study.petshop.Entity.Pet;
import study.petshop.Repository.MemberRepository;
import study.petshop.Repository.PetRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class PetshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetshopApplication.class, args);
    }

    @Component
    @Profile("init")
    @RequiredArgsConstructor
    public static class Init {
        private final PetRepository petRepository;
        private final MemberRepository memberRepository;

        @PostConstruct
        public void init() {
            log.info("INIT DATA UPLOADING START..");

            Member member_1 = new Member(null, "init_member_1", 25, null);
            Member member_2 = new Member(null, "init_member_2", 15, null);
            memberRepository.save(member_1);
            memberRepository.save(member_2);
            Pet pet_1 = new Pet(null, "init_dog",3, member_1);
            Pet pet_2 = new Pet(null, "init_cat",2, member_1);
            petRepository.save(pet_1);
            petRepository.save(pet_2);
            log.info("INIT DATA SAVING..");
            List<Pet> list = new ArrayList<>();
            list.add(pet_1);
            list.add(pet_2);
            Optional<Member> mem_list = memberRepository.findById(member_1.getMember_id());
            Member mem = mem_list.get();
            mem.setMy_pet(list);
            memberRepository.save(mem);
            log.info("INIT DATA UPLOADING COMPLETE..");
        }
    }

}
