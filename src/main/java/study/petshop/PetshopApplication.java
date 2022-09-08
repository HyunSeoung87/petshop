package study.petshop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import study.petshop.Entity.Pet;
import study.petshop.Repository.PetRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class PetshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetshopApplication.class, args);
    }

    @Component
    @RequiredArgsConstructor
    public static class Init {
        private final PetRepository petRepository;

        @PostConstruct
        public void init() {
            log.info("INIT DATA UPLOADING..");

            Pet pet_1 = new Pet(null, "init_dog",3);
//            if(petRepository.findById(pet_1.getPet_id()) == null){
//                petRepository.save(pet_1);
//            }
            petRepository.save(pet_1);


        }
    }

}
