package study.petshop.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.petshop.Entity.Pet;
import study.petshop.Repository.PetRepository;
import study.petshop.dto.PetDto;

import java.util.List;
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
                    .build()).collect(Collectors.toList());
    }
}
