package com.scbw.SpringCodingBaseWeb.board.service;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.mapper.BoardMapper;
import com.scbw.SpringCodingBaseWeb.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board insert(BoardDTO boardDTO) {
        return save(boardDTO);
    }

    public Board update(BoardDTO boardDTO) {
        return save(boardDTO);
    }

    public Boolean delete(String boardId) {
        try {
            boardRepository.deleteById(boardId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Board save(BoardDTO boardDTO) {
        Board board = boardMapper.dtoToEntity(boardDTO);
        return boardRepository.save(board);
    }
}
