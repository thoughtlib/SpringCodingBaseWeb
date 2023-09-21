package com.scbw.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scbw.board.dto.BoardDTO;
import com.scbw.board.entity.Board;
import com.scbw.board.service.BoardService;
import com.scbw.util.UUIDGenerator;

@SpringBootTest
@Ignore
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
                .build();

        Board board = boardService.insert(dto);
        Board findBoard = boardService.findById(board.getBoardId());

        assertThat(board).isNotNull();
        assertThat(findBoard).isNotNull();
    }
}
