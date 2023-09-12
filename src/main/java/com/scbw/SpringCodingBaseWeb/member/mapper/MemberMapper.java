package com.scbw.SpringCodingBaseWeb.member.mapper;

import com.scbw.SpringCodingBaseWeb.member.dto.MemberDTO;
import com.scbw.SpringCodingBaseWeb.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberDTO entityToDto(Member member);
    Member dtoToEntity(MemberDTO memberDTO);
    List<MemberDTO> entityListToDtoList(List<Member> memberList);
    List<Member> dtoListToEntityList(List<Member> memberDTOList);
}
