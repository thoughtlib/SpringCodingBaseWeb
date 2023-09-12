package com.scbw.SpringCodingBaseWeb.member.repository;

import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
