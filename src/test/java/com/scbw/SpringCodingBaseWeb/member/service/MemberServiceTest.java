package com.scbw.SpringCodingBaseWeb.member.service;

import com.scbw.SpringCodingBaseWeb.member.dto.MemberDTO;
import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import com.scbw.SpringCodingBaseWeb.member.mapper.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    @DisplayName("회원 가입")
    @Rollback(value = false)
    void join() {
        Random random = new Random();

        MemberDTO memberDTO = MemberDTO.builder()
                .memberId("test" + random.nextInt() % 100)
                .password("test" + random.nextInt() % 100)
                .alias("test" + random.nextInt() % 100)
                .realName("test" + random.nextInt() % 100)
                .isAdmin(false)
                .isLoggedIn(false)
                .isDeleted(false)
                .build();

        Optional<Member> joinedMember = memberService.join(memberDTO);
        Optional<Member> findMember = memberService.findById(memberDTO.getMemberId());
        Assertions.assertThat(joinedMember.isPresent()).isTrue();
        Assertions.assertThat(findMember.isPresent()).isTrue();
        Assertions.assertThat(findMember.get().getMemberId()).isEqualTo(joinedMember.get().getMemberId());
    }
}