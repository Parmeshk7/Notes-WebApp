package com.nagarro.notesapp.service.impl;

import com.nagarro.notesapp.model.entity.Note;
import com.nagarro.notesapp.model.entity.User;
import com.nagarro.notesapp.repository.NoteRepository;
import com.nagarro.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        note.setCreatedAt(new Date());
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Integer noteId) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getTenRecentNotes(User user) {
        return noteRepository.findTop10ByUserOrderByCreatedAtDesc(user);
    }

}
