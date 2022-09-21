package study.petshop.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.petshop.Entity.Pet;
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
        Treatment result = new Treatment(treatmentDTO.getRoomNum(),pet,false);
        Pet pet_id = result.getPet_id();
        return pet_id.getPet_id();
    }

    public void useTreatment(Long pet_id, TreatmentDTO treatmentDTO) {
        Optional<Treatment> treatment = treatmentRepository.findById(treatmentDTO.getRoomNum());
        Treatment treatment1 = treatment.orElseThrow();
        treatment1.setUsing(true); // 사용 시작
        Optional<Pet> pet = petRepository.findById(pet_id);
        Pet pet1 = pet.orElseThrow();
        treatment1.setPet_id(pet1);
        treatmentRepository.save(treatment1);
    }

    public ResponsePrescriptDTO outTreatment(Long pet_id, Long roomNum) {
        Optional<Treatment> treatment = treatmentRepository.findById(roomNum);
        Treatment treatment1 = treatment.orElseThrow();
        treatment1.setUsing(false); // 사용 시작
        treatmentRepository.save(treatment1);
        Optional<Pet> pet = petRepository.findById(pet_id);
        Pet pet1 = pet.orElseThrow();
        RequestPrescriptDTO requestPrescriptDTO = new RequestPrescriptDTO(treatment1,pet1);
        return prescriptService.createPrescript(requestPrescriptDTO);
    }
}
