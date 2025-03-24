package com.anchorsbiz.basic.repository;

import com.anchorsbiz.basic.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
    @Query("SELECT n FROM Note n WHERE n.user.id = :userId")
    List<Note> findNoteByUserId(@Param("userId") Long userId);
    
}
