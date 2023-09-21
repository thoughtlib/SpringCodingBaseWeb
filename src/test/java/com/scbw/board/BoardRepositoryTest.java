package com.scbw.board;

import com.scbw.board.dto.BoardSearchDTO;
import com.scbw.board.entity.Board;
import com.scbw.board.repository.BoardRepository;
import com.scbw.util.UUIDGenerator;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Ignore
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
                .build();

        boardRepository.save(board);
    }

    @Test
    public void selectListTest() {
        BoardSearchDTO searchDTO = new BoardSearchDTO();

        List<Board> boardList = boardRepository.findAll(searchDTO);

        assertThat(boardList).isNotNull();
    }
}