package com.scbw.SpringCodingBaseWeb.member.repository;

import com.scbw.SpringCodingBaseWeb.member.dto.MemberDTO;
import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    private String memberId;

    @BeforeEach
    void beforeEach() {
        Random random = new Random();

        Member member = Member.builder()
                .memberId("test" + random.nextInt() % 100)
                .password("test" + random.nextInt() % 100)
                .alias("test" + random.nextInt() % 100)
                .realName("test" + random.nextInt() % 100)
                .isAdmin(false)
                .isLoggedIn(false)
                .isDeleted(false)
                .build();

        memberId = member.getMemberId();

        memberRepository.save(member);
    }

    @Test
    @DisplayName("회원 검색")
    @Rollback(value = false)
    void findById() {
        Optional<Member> member = memberRepository.findById(memberId);

        assertThat(member.isPresent()).isTrue();
        assertThat(member.get().getMemberId()).isEqualTo(memberId);
    }

    @Test
    @DisplayName("회원 추가")
    @Rollback(value = false)
    void save() {
        Random random = new Random();

        Member member = Member.builder()
                .memberId("test" + random.nextInt() % 100)
                .password("test" + random.nextInt() % 100)
                .alias("test" + random.nextInt() % 100)
                .realName("test" + random.nextInt() % 100)
                .isAdmin(false)
                .isLoggedIn(false)
                .isDeleted(false)
                .build();

        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(member.getMemberId());

        assertThat(findMember.get().getMemberId()).isEqualTo(savedMember.getMemberId());
    }
}