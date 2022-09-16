package study.petshop.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.petshop.Entity.Member;
import study.petshop.Entity.Pet;
import study.petshop.Entity.Treatment;
import study.petshop.Repository.MemberRepository;
import study.petshop.Repository.PetRepository;
import study.petshop.Repository.TreatmentRepository;
import study.petshop.dto.MemberDto;
import study.petshop.dto.PetDto;
import study.petshop.dto.TreatmentDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final MemberRepository memberRepository;
    private final PetRepository petRepository;


    public Long create(TreatmentDTO treatmentDTO) {
        Pet pet = treatmentDTO.getPet_id();
        Treatment result = new Treatment(treatmentDTO.getRoomNum(),pet);
        Pet pet_id = result.getPet_id();
        return pet_id.getPet_id();
    }

}
