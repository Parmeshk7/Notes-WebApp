package com.nagarro.notesapp.repository;

import com.nagarro.notesapp.model.entity.Note;
import com.nagarro.notesapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    public List<Note> findTop10ByUserOrderByCreatedAtDesc(User user);
}
