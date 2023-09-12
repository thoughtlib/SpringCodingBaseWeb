package com.scbw.SpringCodingBaseWeb.member.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    @Id
    @Column(length = 30) // TODO: 할당한 길이가 적절한지 검토 필요
    String memberId;

    @Column(length = 16) // TODO: 할당한 길이가 적절한지 검토 필요
    String password;

    @Column(length = 12) // TODO: 할당한 길이가 적절한지 검토 필요
    String alias; // 이름 대신 공개되는 별칭

    @Column(length = 12)
    String realName; // 실제 사용자 명

    @Column(length = 1)
    Boolean isAdmin; // true = 관리자, false = 일반 사용자

    @Column(length = 1)
    Boolean isLoggedIn;

    @Column(length = 1)
    Boolean isDeleted;
}
