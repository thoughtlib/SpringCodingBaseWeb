package com.scbw.SpringCodingBaseWeb.board;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.service.BoardService;
import com.scbw.SpringCodingBaseWeb.util.UUIDGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("BoardService 저장 테스트")
    void save() throws Exception {
        BoardDTO dto = BoardDTO.builder()
                .boardId(UUIDGenerator.generate())
                .title("saved by service")
                .content("no content")
                .writer("no wirter")
                .used(true)
                .build();

        Board board = boardService.insert(dto);
        Board findBoard = boardService.findById(board.getBoardId());

        assertThat(board).isNotNull();
    }
}
