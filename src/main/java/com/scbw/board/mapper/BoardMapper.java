package com.scbw.board.mapper;

import com.scbw.board.dto.BoardDTO;
import com.scbw.board.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {
    BoardDTO entityToDto(Board board);
    Board dtoToEntity(BoardDTO boardDTO);
    List<BoardDTO> entityListToDtoList(List<Board> boardList);
    List<Board> dtoListToEntityList(List<BoardDTO> boardDTOLIst);
}
