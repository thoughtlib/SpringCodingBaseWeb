package com.scbw.SpringCodingBaseWeb.member.service;

import com.scbw.SpringCodingBaseWeb.member.dto.MemberDTO;
import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import com.scbw.SpringCodingBaseWeb.member.mapper.MemberMapper;
import com.scbw.SpringCodingBaseWeb.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Optional<Member> login(@NotNull String memberId, @NotNull String password) {
        return findById(memberId).filter(v -> password.equals(v.getPassword()));
    }

    @Transactional
    public Optional<Member> join(MemberDTO memberDTO) {
        Member member = memberMapper.dtoToEntity(memberDTO);
        return Optional.of(memberRepository.save(member));
    }

    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    public Optional<Member> findById(String memberId) {
        return memberRepository.findById(memberId);
    }
}
