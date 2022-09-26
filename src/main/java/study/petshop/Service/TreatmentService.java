package study.petshop.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.petshop.Entity.Pet;
import study.petshop.Entity.Prescript;
import study.petshop.Entity.Treatment;
import study.petshop.Repository.MemberRepository;
import study.petshop.Repository.PetRepository;
import study.petshop.Repository.PrescriptRepository;
import study.petshop.Repository.TreatmentRepository;
import study.petshop.dto.RequestPrescriptDTO;
import study.petshop.dto.ResponsePrescriptDTO;
import study.petshop.dto.TreatmentDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final MemberRepository memberRepository;
    private final PetRepository petRepository;
    private final PrescriptRepository prescriptRepository;
    private final PrescriptService prescriptService;


    public Long create(TreatmentDTO treatmentDTO) {
        Pet pet = treatmentDTO.getPet_id();
        Treatment result = new Treatment(treatmentDTO.getId(),pet, false, null);
        Pet pet_id = result.getPet_id();
        return pet_id.getPet_id();
    }

    public void useTreatment(Long pet_id, TreatmentDTO treatmentDTO) {
        Optional<Treatment> treatment = treatmentRepository.findById(treatmentDTO.getId());
        Treatment treatment1 = treatment.orElseThrow();
        treatment1.setUsing(true); // 치료 중..
        Optional<Pet> pet = petRepository.findById(pet_id);
        Pet pet1 = pet.orElseThrow();
        treatment1.setPet_id(pet1);
        treatmentRepository.save(treatment1);
    }

    public ResponsePrescriptDTO outTreatment(Long pet_id, Long treat_id) {

        Optional<Pet> pet = petRepository.findById(pet_id);
        Pet pet1 = pet.orElseThrow();

        Optional<Treatment> treatment = treatmentRepository.findById(treat_id);
        Treatment treatment1 = treatment.orElseThrow();
        treatment1.setUsing(false); // 치료 완료..
        treatmentRepository.save(treatment1);

        RequestPrescriptDTO requestPrescriptDTO = new RequestPrescriptDTO(treatment1,pet1);
        ResponsePrescriptDTO prescript = prescriptService.createPrescript(requestPrescriptDTO);
        Optional<Prescript> byId = prescriptRepository.findById(prescript.getId());
        Prescript prescript2 = byId.orElseThrow();
        treatment1.setPrescript_id(prescript2);
        treatmentRepository.save(treatment1);
        prescript2.setTreat_id(treatment1);
        prescriptRepository.save(prescript2);

        return prescript;
    }

    public TreatmentDTO getTreatment(Long pet_id) {
        Optional<Pet> pet = petRepository.findById(pet_id);
        Pet pet1 = pet.orElseThrow();
        Optional<Treatment> treatmentsByPet_id = treatmentRepository.getTreatmentsByPet_id(pet1);
        Treatment treatment = treatmentsByPet_id.orElseThrow();
        TreatmentDTO treatmentDTO = new TreatmentDTO(treatment.getTreat_id(),treatment.getPet_id());
        return treatmentDTO;
    }
}
