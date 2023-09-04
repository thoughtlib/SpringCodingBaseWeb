package com.scbw.SpringCodingBaseWeb.board.repository.custom;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardSearchDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class BoardCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardCustomRepository {

    public BoardCustomRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> findAll(BoardSearchDTO search, Pageable pageable) {
        return null;
    }

    @Override
    public List<Board> findAll(BoardSearchDTO search) {
        return null;
    }
}
