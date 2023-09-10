package com.scbw.SpringCodingBaseWeb.board.repository;

import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.repository.custom.BoardCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String>, BoardCustomRepository {
}
