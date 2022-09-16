package study.petshop.Controller.Rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.petshop.Entity.Member;
import study.petshop.Repository.MemberRepository;
import study.petshop.Service.MemberService;
import study.petshop.dto.CommonResponse;
import study.petshop.dto.MemberDto;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<?>>> getAllMembers() {
        List<MemberDto> data = memberService.getAllMembers();
        CommonResponse<List<?>> result = CommonResponse.success(data,null);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createMember(@RequestBody MemberDto memberDto) {
        Long member_id = memberService.create(memberDto);
        log.info(String.valueOf(member_id));
        CommonResponse<?> result = CommonResponse.success(member_id,null);
        return ResponseEntity.ok(result);
    }

}
