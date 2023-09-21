package com.scbw.board.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.scbw.board.service.BoardService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
public class BoardController {

    BoardService boardService;

    @GetMapping(path = "/board/list",params = "!boardId")
    public String boardList() {
        return "pages/board/list";
    }

    @GetMapping("/board/detail/{boardId}")
    public String board(@PathVariable String boardId, Model model) {
        if (boardId != null && !boardId.isEmpty()) {
            model.addAttribute("boardId", boardId);
            model.addAttribute("state", "SUCCESS");
        } else {
            model.addAttribute("state", "FAIL");
        }

        return "pages/board/detail";
    }

    @GetMapping("/board/create")
    public String create() {
        return "pages/board/create";
    }

    @GetMapping("/board/edit")
    public String update(@RequestParam("boardId") String boardId, Model model) {
        if (boardId != null && !boardId.isEmpty()) {
            model.addAttribute("boardId", boardId);
            model.addAttribute("state", "SUCCESS");
        } else {
            model.addAttribute("state", "FAIL");
        }

        return "pages/board/edit";
    }
}
