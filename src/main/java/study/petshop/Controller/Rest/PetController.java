package study.petshop.Controller.Rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.petshop.Entity.Pet;
import study.petshop.Service.PetService;
import study.petshop.dto.PetDto;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDto>> getAllPets() {

        List<PetDto> list = petService.getAllPets();

        return ResponseEntity.ok(list);
    }

}
