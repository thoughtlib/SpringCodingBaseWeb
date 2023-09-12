package com.scbw.SpringCodingBaseWeb.board.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardSearchDTO {
    String boardId;
    String title;
    String content;
    String writer;
}
