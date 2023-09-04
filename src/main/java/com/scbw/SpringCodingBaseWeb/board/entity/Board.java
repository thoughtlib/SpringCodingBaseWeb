package com.scbw.SpringCodingBaseWeb.board.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @Column(length = 40)
    private String boardId;

    @Column(length = 300)
    private String title;

    @Column(length = 3000)
    private String content;

    @Column(length = 40)
    private String writer;

    @Column(length = 1)
    private Boolean used;
}
