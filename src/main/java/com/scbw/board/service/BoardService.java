package com.scbw.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbw.board.dto.BoardDTO;
import com.scbw.board.dto.BoardSearchDTO;
import com.scbw.board.entity.Board;
import com.scbw.board.mapper.BoardMapper;
import com.scbw.board.repository.BoardRepository;
import com.scbw.util.UUIDGenerator;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public Page<Board> findAll(BoardSearchDTO search, Pageable pageable) {
        return boardRepository.findAll(search, pageable);
    }

    public Board findById(String id) {
        return boardRepository.findById(id).get();
    }

    @Transactional
    public Board insert(BoardDTO boardDTO) throws Exception {
        boardDTO.setBoardId(UUIDGenerator.generate());
        return save(boardDTO);
    }

    @Transactional
    public Board update(BoardDTO boardDTO) throws Exception {
        boardDTO.setIsVisible(true);
        boardDTO.setIsDeleted(false);
        return save(boardDTO);
    }

    @Transactional
    public void delete(String boardId) throws Exception {
        boardRepository.deleteById(boardId);
    }

    private Board save(BoardDTO boardDTO) throws Exception {
        Board board = boardMapper.dtoToEntity(boardDTO);
        return boardRepository.save(board);
    }
}
