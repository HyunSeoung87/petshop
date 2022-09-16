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
    // 기능 리스트
    // 1. 보유한 모든 펫 조회 (ok)
    // 2. 치료실 들어가기, 나오기
    // 3. 치료실 들어가고 나오면 처방전 자동 발급
    // 4. 환자 이메일로 처방전 전송

    // 해야할 일
    // 1. treatment (치료실) 엔티티 생성 (ok)
    // 2. prescript (처방전) 엔티티 생성 (ok)
    // 3. 치료실 출입 API 작성
    // 4. 처방전 발급 API 작성
    // 5. SMTP를 이용한 처방전 전송 작성
    // 6. CI/CD를 위한 Jenkins or Docker 작업 진행.. 만약 Jenkins 사용 불가 시, Github Actions 사용 고려

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
