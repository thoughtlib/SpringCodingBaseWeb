package com.scbw.SpringCodingBaseWeb.board.controller;

import com.scbw.SpringCodingBaseWeb.board.dto.BoardDTO;
import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.service.BoardService;
import com.scbw.SpringCodingBaseWeb.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 목록 조회
     */
    @GetMapping(params = "!boardId")
    public String boards(Model model, Pageable pageable) {
        Page<Board> boards = boardService.findAll(pageable);

        List<Board> usedBoards = boards.stream()
                .filter(Board::getUsed)
                .collect(Collectors.toList());

        model.addAttribute("boards", usedBoards);

        return "board/boards";
    }

    /**
     * 단일 게시글 상세 조회
     * @param boardId 게시글 ID
     */
    @GetMapping
    public String board(@RequestParam("boardId") String boardId, Model model) {
        boardService.findById(boardId)
                .ifPresent(v -> model.addAttribute("board", v));

        return "board/board";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String save(@ModelAttribute BoardDTO boardDTO, Model model) {
        Board board = boardService.insert(boardDTO);
        model.addAttribute("board", board);

        return "board/board";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("boardId") String boardId, Model model) {
        boardService.findById(boardId)
                .ifPresent(v -> model.addAttribute("board", v));
        return "board/updateForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        Board board = boardService.update(boardDTO);
        model.addAttribute("board", board);

        return "board/board";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam("boardId") String boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "board/deleteForm";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute("boardId") String boardId, Model model) {
        if (!boardService.delete(boardId)) {
            log.error("{} 삭제 실패", boardId);
        }

        return "redirect:/board";
    }
}
