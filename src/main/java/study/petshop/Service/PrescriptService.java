package study.petshop.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.petshop.Entity.Pet;
import study.petshop.Entity.Prescript;
import study.petshop.Entity.Treatment;
import study.petshop.Repository.PrescriptRepository;
import study.petshop.dto.RequestPrescriptDTO;
import study.petshop.dto.ResponsePrescriptDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PrescriptService {
    private final PrescriptRepository prescriptRepository;


    public ResponsePrescriptDTO createPrescript(RequestPrescriptDTO requestPrescriptDTO) {
        Prescript prescript = new Prescript(requestPrescriptDTO.getTreatment(),requestPrescriptDTO.getPet());
        prescriptRepository.save(prescript);
        return ResponsePrescriptDTO.builder()
                .id(prescript.getId())
                .pet(prescript.getPet_id())
                .treatment(prescript.getTreat_id())
                .build();
    }

    public ResponsePrescriptDTO getPrescript(Long id) {
        Optional<Prescript> prescript = prescriptRepository.findById(id);
        Prescript prescript1 = prescript.orElseThrow();
        return ResponsePrescriptDTO.builder().id(prescript1.getId()).treatment(prescript1.getTreat_id()).pet(prescript1.getPet_id()).build();
    }
}
