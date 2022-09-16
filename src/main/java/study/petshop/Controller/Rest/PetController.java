package study.petshop.Controller.Rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.petshop.Entity.Pet;
import study.petshop.Service.PetService;
import study.petshop.dto.CommonResponse;
import study.petshop.dto.ErrorInfo;
import study.petshop.dto.PetDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Optional>>> getAllPets() {
        List<PetDto> list = petService.getAllPets();
        if (list.isEmpty()) {
            ErrorInfo errorInfo = new ErrorInfo("404","전체 조회 실패");
            CommonResponse<List<Optional>> error = CommonResponse.error(errorInfo);
            return ResponseEntity.ok(error);
        }
        CommonResponse<List<Optional>> result = CommonResponse.success(list, null);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CommonResponse<PetDto>> createPet(@RequestBody PetDto petDto) {
        Long pet = petService.create(petDto);
        CommonResponse<PetDto> result = CommonResponse.success(petService.getPet(pet),null);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<Optional>> getPet (@PathVariable Long id) {
        PetDto petDto = petService.getPet(id);
        if (petDto != null){
            CommonResponse<Optional> pet = CommonResponse.success(petDto,null);
            return ResponseEntity.ok(pet);
        }
        ErrorInfo error = new ErrorInfo("404","단일 조회 실패");
        CommonResponse<Optional> errorInfo = CommonResponse.error(error);
        return ResponseEntity.ok(errorInfo);
    }

}
