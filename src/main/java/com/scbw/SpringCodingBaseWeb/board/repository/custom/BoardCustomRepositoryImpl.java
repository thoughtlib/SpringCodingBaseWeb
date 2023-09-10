package com.scbw.SpringCodingBaseWeb.board.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import com.scbw.SpringCodingBaseWeb.board.dto.BoardSearchDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.entity.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class BoardCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardCustomRepository {

    public BoardCustomRepositoryImpl() {
        super(Board.class);
    }

    static QBoard qBoard;

    @Override
    public Page<Board> findAll(BoardSearchDTO searchDTO, Pageable pageable) {
        JPQLQuery query = from(qBoard);
        setWhereClauseInSearchDTO(searchDTO, query);

        query = getQuerydsl().applyPagination(pageable, query);

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public List<Board> findAll(BoardSearchDTO searchDTO) {
        JPQLQuery query = from(qBoard);
        setWhereClauseInSearchDTO(searchDTO, query);

        return query.fetch();
    }

    private void setWhereClauseInSearchDTO(BoardSearchDTO searchDTO, JPQLQuery query) {

    }
}
