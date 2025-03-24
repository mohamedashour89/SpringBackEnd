package com.anchorsbiz.basic.controller;

import com.anchorsbiz.basic.dto.NoteDTO;
import com.anchorsbiz.basic.service.NoteService;
import com.anchorsbiz.basic.util.JwtUtil;
import com.anchorsbiz.basic.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;
    private final JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<String> createNote(
            @Valid @RequestBody NoteDTO noteDTO,
            @RequestHeader("Authorization") String token) {
        try {
            if (token == null || !token.startsWith("Bearer ") || token.split("\\.").length != 3) {
                throw new UnauthorizedException("Invalid token format");
            }
            String bearerToken = token.substring(7);
            Long userId = jwtUtil.getUserIdFromToken(bearerToken);
            log.debug("Creating note for user ID: {}", userId);

            noteService.createNote(noteDTO, userId);
            return ResponseEntity.ok("Notes was created successfully");

        } catch (Exception e) {
            log.error("An error occured while creating the note. Details: {}", e.getMessage());
            throw e;
        }

        }


        @GetMapping
        public ResponseEntity<List<NoteDTO>> getUserNotes(
                @RequestHeader("Authorization") String token) {
            try {
                String bearerToken = token.substring(7);
                Long userId = jwtUtil.getUserIdFromToken(bearerToken);
                List<NoteDTO> notes = noteService.getUserNotes(userId);
                return ResponseEntity.ok(notes);

            } catch (Exception e) {
                log.error("An error occured while getting the notes");
                throw e;
            }
                }
    
}
