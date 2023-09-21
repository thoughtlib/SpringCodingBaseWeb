package com.scbw.board.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import com.scbw.board.dto.BoardSearchDTO;
import com.scbw.board.entity.Board;
import com.scbw.board.entity.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class BoardCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardCustomRepository {
    public BoardCustomRepositoryImpl() {
        super(Board.class);
    }

    QBoard qBoard = QBoard.board;

    @Override
    public Page<Board> findAll(BoardSearchDTO search, Pageable pageable) {
        JPQLQuery<Board> query = from(qBoard);
        setWhereClauseBySearchDTO(search, query);

        query = getQuerydsl().applyPagination(pageable, query);

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public List<Board> findAll(BoardSearchDTO search) {
        JPQLQuery query = from(qBoard);
        setWhereClauseBySearchDTO(search, query);

        return query.fetch();
    }

    private void setWhereClauseBySearchDTO(BoardSearchDTO search, JPQLQuery query) {
        if(!StringUtils.isEmpty(search.getTitle())) {
            query.where(qBoard.title.contains(search.getTitle()));
        }
        if(!StringUtils.isEmpty(search.getWriter())) {
            query.where(qBoard.writer.contains(search.getWriter()));
        }
        if(!StringUtils.isEmpty(search.getBoardId())) {
            query.where(qBoard.boardId.eq(search.getBoardId()));
        }
        if(!StringUtils.isEmpty(search.getContent())) {
            query.where(qBoard.content.contains(search.getContent()));
        }
    }
}
