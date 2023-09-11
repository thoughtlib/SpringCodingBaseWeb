package com.scbw.SpringCodingBaseWeb.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private String boardId;
    private String title, content;
    private String writer;
    private Boolean isVisible;
    private Boolean isDeleted;
}
