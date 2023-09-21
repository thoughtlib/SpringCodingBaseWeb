package com.scbw.board.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Board {
    @Id
    @Column(length = 40)
    String boardId;

    @Column(length = 300)
    String title;

    @Column(length = 3000)
    String content;

    @Column(length = 40)
    String writer;

    @Column(length = 1)
    Boolean isVisible;

    @Column(length = 1)
    Boolean isDeleted;
}
