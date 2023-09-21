package com.scbw.board.repository.custom;

import com.scbw.board.dto.BoardSearchDTO;
import com.scbw.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardCustomRepository {
    Page<Board> findAll(BoardSearchDTO searchDTO, Pageable pageable);

    List<Board> findAll(BoardSearchDTO searchDTO);

}
