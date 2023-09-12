package com.scbw.SpringCodingBaseWeb.board.service;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardDTO;
import com.scbw.SpringCodingBaseWeb.board.dto.BoardSearchDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.mapper.BoardMapper;
import com.scbw.SpringCodingBaseWeb.board.repository.BoardRepository;
import com.scbw.SpringCodingBaseWeb.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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
        boardDTO.setUsed(true);

        return save(boardDTO);
    }

    @Transactional
    public Board update(BoardDTO boardDTO) throws Exception {
        boardDTO.setUsed(true);
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
