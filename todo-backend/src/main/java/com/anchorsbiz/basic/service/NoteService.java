package com.anchorsbiz.basic.service;

import com.anchorsbiz.basic.dto.NoteDTO;
import com.anchorsbiz.basic.entity.Note;
import com.anchorsbiz.basic.entity.User;
import com.anchorsbiz.basic.repository.NoteRepository;
import com.anchorsbiz.basic.repository.UserRepository;
import com.anchorsbiz.basic.mapper.NoteMapper;
import com.anchorsbiz.basic.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteMapper noteMapper;

    public void createNote(NoteDTO noteDTO, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("This user is not registered user: " + userId));

        Note note = noteMapper.toEntity(noteDTO);
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        note.setUser(user);
        note.setCreatedDate(LocalDateTime.now());
        note.setUpdatedDate(LocalDateTime.now());

        noteRepository.save(note);
    }


    public List<NoteDTO> getUserNotes(Long userId){
        List<Note> notes = noteRepository.findNoteByUserId(userId);
        return noteMapper.toDTOList(notes);
    }
    
}
