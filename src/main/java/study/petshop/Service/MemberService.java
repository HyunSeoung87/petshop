package study.petshop.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.petshop.Entity.Member;
import study.petshop.Repository.MemberRepository;
import study.petshop.dto.MemberDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberDto> getAllMembers() {
        List<Member> lists = memberRepository.findAll();

        return lists.stream().map( l -> MemberDto.builder()
                .member_id(l.getMember_id())
                .member_old(l.getMember_old())
                .member_name(l.getMember_name())
                .my_pet(l.getMy_pet())
                .build()).collect(Collectors.toList());
    }

    public Long create(MemberDto memberDto) {
        Member member = memberRepository.save(new Member(memberDto.getMember_id(),
                memberDto.getMember_name(),
                memberDto.getMember_old(), null));
        return member.getMember_id();
    }
}
