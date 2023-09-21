package com.scbw.board.repository;

import com.scbw.board.entity.Board;
import com.scbw.board.repository.custom.BoardCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String>, BoardCustomRepository {
}
