package com.scbw.SpringCodingBaseWeb.board.repository.custom;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardSearchDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardCustomRepository {
    Page<Board> findAll(BoardSearchDTO search, Pageable pageable);

    List<Board> findAll(BoardSearchDTO search);

}
