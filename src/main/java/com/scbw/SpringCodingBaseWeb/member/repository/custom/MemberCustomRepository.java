package com.scbw.SpringCodingBaseWeb.member.repository.custom;

import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import com.scbw.SpringCodingBaseWeb.member.entity.MemberSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberCustomRepository {
    Page<Member> findAll(MemberSearchDTO search, Pageable pageable);

    List<Member> findAll(MemberSearchDTO search);
}
