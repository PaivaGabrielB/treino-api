package br.com.treino.api.service;

import br.com.treino.model.entity.Member;
import br.com.treino.model.input.MemberInput;
import br.com.treino.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found!"));
    }

    public List<Member> listAllMembers() {
        return memberRepository.findAll();
    }

    public Member save(MemberInput memberInput) {
        Member member = modelMapper.map(memberInput, Member.class);
        return memberRepository.save(member);
    }

    public Member updateById(Long id, MemberInput memberInput) {
        Member member = findById(id);
        modelMapper.map(memberInput, member);
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        Member member = findById(id);
        memberRepository.delete(member);
    }
}
