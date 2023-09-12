package com.scbw.SpringCodingBaseWeb.board.presentation;

import com.scbw.SpringCodingBaseWeb.board.entity.Board;
import com.scbw.SpringCodingBaseWeb.board.service.BoardService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
public class BoardController {

    BoardService boardService;

    @GetMapping(path = "/board/list",params = "!boardId")
    public String boardList() {
        return "board/list";
    }

    @GetMapping("/board/detail/{boardId}")
    public String board(@PathVariable String boardId, Model model) {
        if (boardId != null && !boardId.isEmpty()) {
            model.addAttribute("boardId", boardId);
            model.addAttribute("state", "SUCCESS");
        } else {
            model.addAttribute("state", "FAIL");
        }

        return "board/detail";
    }

    @GetMapping("/board/create")
    public String create() {
        return "board/create";
    }

    @GetMapping("/board/edit")
    public String update(@RequestParam("boardId") String boardId, Model model) {
//        Board board = boardService.findById(boardId);
//
//        if(board != null) {
//            model.addAttribute("board", board);
//            model.addAttribute("state", "SUCCESS");
//        } else {
//            model.addAttribute("state", "FAIL");
//        }
        if (boardId != null && !boardId.isEmpty()) {
            model.addAttribute("boardId", boardId);
            model.addAttribute("state", "SUCCESS");
        } else {
            model.addAttribute("state", "FAIL");
        }

        return "/board/edit";
    }
}
