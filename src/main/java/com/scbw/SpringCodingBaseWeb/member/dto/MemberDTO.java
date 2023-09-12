package com.scbw.SpringCodingBaseWeb.member.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    String memberId;
    String password;
    String alias; // 이름 대신 공개되는 별칭
    String realName; // 실제 사용자 명
    Boolean isAdmin; // true = 관리자, false = 일반 사용자
    Boolean isLoggedIn;
    Boolean isDeleted;
}