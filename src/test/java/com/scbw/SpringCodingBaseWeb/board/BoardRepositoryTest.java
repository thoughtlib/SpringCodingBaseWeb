package com.scbw.SpringCodingBaseWeb.board;

import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.repository.BoardRepository;
import com.scbw.SpringCodingBaseWeb.board.repository.custom.BoardCustomRepositoryImpl;
import com.scbw.SpringCodingBaseWeb.util.UUIDGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @Rollback(value = false)
    public void insertBoard() {
        Board board = Board.builder()
                .boardId(UUIDGenerator.generate())
                .title("test title")
                .content("test content")
                .writer("test wirter")
                .used(true)
                .build();

        boardRepository.save(board);
    }

}
