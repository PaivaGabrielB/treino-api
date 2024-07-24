package br.com.treino.api.controller;

import br.com.treino.api.service.MemberService;
import br.com.treino.model.entity.Member;
import br.com.treino.model.input.MemberInput;
import br.com.treino.model.output.MemberOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MemberInput memberInput) {
        Member createdMember = memberService.save(memberInput);
        MemberOutput memberOutput = new MemberOutput(createdMember);
        return ResponseEntity.ok(memberOutput);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid MemberInput memberInput) {
        Member updatedMember = memberService.updateById(id, memberInput);
        MemberOutput memberOutput = new MemberOutput(updatedMember);
        return ResponseEntity.ok(memberOutput);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deactivateById(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\"Member deleted successfully\"}");
    }

    @GetMapping
    public ResponseEntity<List<MemberOutput>> listAll() {
        List<Member> members = memberService.listAllMembers();
        List<MemberOutput> responseDTOS = members.stream()
                .map(MemberOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberOutput> getById(@PathVariable Long id) {
        Member member = memberService.findById(id);
        MemberOutput memberOutput = new MemberOutput(member);
        return ResponseEntity.ok(memberOutput);
    }
}
