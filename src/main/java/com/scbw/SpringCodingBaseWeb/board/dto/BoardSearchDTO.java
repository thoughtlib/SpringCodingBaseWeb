package com.scbw.SpringCodingBaseWeb.board.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardSearchDTO {

    private String id;
    private String title;
    private String content;
    private String writer;
}
