package com.anchorsbiz.basic.mapper;

import com.anchorsbiz.basic.dto.NoteDTO;
import com.anchorsbiz.basic.entity.Note;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class NoteMapper {

    public NoteDTO toDTO(Note entity) {
        if (entity == null){
            return null;
        }

        NoteDTO dto = new NoteDTO();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;

    }

    public Note toEntity(NoteDTO dto) {
        if (dto == null) {
            return null;
        }

        Note entity = new Note();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public List<NoteDTO> toDTOList(List<Note> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
}
