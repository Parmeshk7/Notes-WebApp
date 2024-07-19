package com.nagarro.notesapp.service;

import com.nagarro.notesapp.model.entity.Note;
import com.nagarro.notesapp.model.entity.User;

import java.util.List;

public interface NoteService {

    public Note createNote(Note note);

    public void deleteNote(Integer noteId);

    public List<Note> getTenRecentNotes(User user);
}
