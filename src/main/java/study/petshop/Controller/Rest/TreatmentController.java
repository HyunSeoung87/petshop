package study.petshop.Controller.Rest;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.petshop.Entity.Prescript;
import study.petshop.Service.PrescriptService;
import study.petshop.Service.TreatmentService;
import study.petshop.dto.CommonResponse;
import study.petshop.dto.ResponsePrescriptDTO;
import study.petshop.dto.TreatmentDTO;

@RestController
@Data
@Builder
@RequestMapping("/api/treatments")
public class TreatmentController {
    private final TreatmentService treatmentService;
    private final PrescriptService prescriptService;


    @PostMapping
    public ResponseEntity<?> createTreatment(@RequestBody TreatmentDTO treatmentDTO) {
        Long id = treatmentService.create(treatmentDTO);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{pet_id}")
    public ResponseEntity<?> getTreatment(@PathVariable Long pet_id) {
        TreatmentDTO treatment = treatmentService.getTreatment(pet_id);
        CommonResponse<TreatmentDTO> treatmentDTOCommonResponse = CommonResponse.success(treatment,null);
        return ResponseEntity.ok(treatmentDTOCommonResponse);
    }

    @PostMapping("/enter/{pet_id}")
    public ResponseEntity<?> enterTreatment(@PathVariable Long pet_id,@RequestBody TreatmentDTO treatmentDTO) {
        treatmentService.useTreatment(pet_id,treatmentDTO);
        CommonResponse<TreatmentDTO> result = CommonResponse.success(treatmentDTO,null);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/out/{pet_id}/{treat_id}")
    public  ResponseEntity<?> outTreatment(@PathVariable Long pet_id, @PathVariable Long treat_id) {
        ResponsePrescriptDTO responsePrescriptDTO = treatmentService.outTreatment(pet_id, treat_id);
        CommonResponse<ResponsePrescriptDTO> result = CommonResponse.success(responsePrescriptDTO,null);
        return ResponseEntity.ok(result);
    }
}
