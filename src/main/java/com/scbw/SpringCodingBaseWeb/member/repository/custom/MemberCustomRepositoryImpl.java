package com.scbw.SpringCodingBaseWeb.member.repository.custom;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardSearchDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.repository.custom.BoardCustomRepository;
import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import com.scbw.SpringCodingBaseWeb.member.entity.MemberSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MemberCustomRepositoryImpl extends QuerydslRepositorySupport implements MemberCustomRepository {

    public MemberCustomRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<Member> findAll(MemberSearchDTO search, Pageable pageable) {
        return null;
    }

    @Override
    public List<Member> findAll(MemberSearchDTO search) {
        return null;
    }
}
