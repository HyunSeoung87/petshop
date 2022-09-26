package study.petshop.Controller.Rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.petshop.Entity.Prescript;
import study.petshop.Service.PrescriptService;
import study.petshop.dto.ResponsePrescriptDTO;

@RestController
@RequestMapping("/api/prescript")
@RequiredArgsConstructor
public class PrescriptController {

    private final PrescriptService prescriptService;

    @GetMapping("/{id}")
    public ResponsePrescriptDTO getPrescript(@PathVariable Long id){
        return prescriptService.getPrescript(id);
    }
}
