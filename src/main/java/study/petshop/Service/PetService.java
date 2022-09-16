package study.petshop.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.petshop.Entity.Pet;
import study.petshop.Repository.PetRepository;
import study.petshop.dto.PetDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 생성자 주입
public class PetService {

    private final PetRepository petRepository;
    public List<PetDto> getAllPets() {
        List<Pet> list = petRepository.findAll();

        return  list.stream().map(p -> PetDto.builder()
                    .pet_id(p.getPet_id())
                    .pet_old(p.getPet_old())
                    .pet_name(p.getPet_name())
                    .member_id(p.getMember())
                    .build()).collect(Collectors.toList());
    }

    public Long create(PetDto petDto) {
        Pet pet = new Pet(petDto.getPet_id(), petDto.getPet_name(), petDto.getPet_old(), petDto.getMember_id());
        petRepository.save(pet);
        PetDto petDto1 = new PetDto(pet.getPet_id(), pet.getPet_name(), pet.getPet_old(), pet.getMember());

        return petDto1.getPet_id();
    }

    public PetDto getPet(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            Pet pet1 = pet.get();
            return new PetDto(pet1.getPet_id(), pet1.getPet_name(), pet1.getPet_old(), pet1.getMember());
        }
        return null;
    }
}
