package study.petshop.Controller.Rest;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.petshop.Service.TreatmentService;
import study.petshop.dto.TreatmentDTO;

@RestController
@Data
@Builder
@RequestMapping("/api/treatments")
public class TreatmentController {
    private final TreatmentService treatmentService;


    @PostMapping
    public ResponseEntity<?> createTreatment(@RequestBody TreatmentDTO treatmentDTO) {
        Long id = treatmentService.create(treatmentDTO);
        return ResponseEntity.ok(id);
    }
}
