package com.scbw.SpringCodingBaseWeb.member.presentation;

import com.scbw.SpringCodingBaseWeb.member.dto.MemberDTO;
import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import com.scbw.SpringCodingBaseWeb.member.service.MemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
public class MemberRestController {

    MemberService memberService;

    @GetMapping(path = "/member/api/list")
    public ResponseEntity memberList(Pageable pageable) {
        // TODO: 관리자 계정 권한인지 확인해야되지 않을 까?
        Page<Member> memberPage = memberService.findAll(pageable);
        return ResponseEntity.ok(memberPage);
    }

    @GetMapping("/member/api/detail/{memberId}")
    public ResponseEntity member(@PathVariable String memberId) {
        try {
            Optional<Member> member = memberService.findById(memberId);
            if (member.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(member.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
        }
    }

    @PostMapping("/member/api/join")
    @ResponseBody
    public ResponseEntity join(@RequestBody MemberDTO memberDTO) {
        if (memberDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
        }

        try {
            Optional<Member> member = memberService.join(memberDTO);
            if (member.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(member.get());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
        }
    }

//    @PostMapping("/member/api/login")
//    @ResponseBody
//    public ResponseEntity login(@RequestBody MemberDTO memberDTO) {
//        if (memberDTO == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
//        }
//
//        try {
//            Optional<Member> member = memberService.join(memberDTO);
//            if (member.isPresent()) {
//                return ResponseEntity.status(HttpStatus.OK).body(member.get());
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
//        }
//    }

//    @PutMapping("/board/api/edit")
//    public ResponseEntity edit(@RequestBody BoardDTO boardDTO) {
//        try {
//            Board board = boardService.update(boardDTO);
//            return ResponseEntity.status(HttpStatus.OK).body(board);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST");
//        }
//    }

//    @DeleteMapping("/board/api/remove/{boardId}")
//    public ResponseEntity delete(@PathVariable("boardId") String boardId) {
//        try {
//            boardService.delete(boardId);
//            return ResponseEntity.status(HttpStatus.OK).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
//        }
//    }
}
