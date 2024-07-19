package com.nagarro.notesapp.controller;

import com.nagarro.notesapp.model.entity.Note;
import com.nagarro.notesapp.model.entity.User;
import com.nagarro.notesapp.model.dto.Response;
import com.nagarro.notesapp.service.NoteService;
import com.nagarro.notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;



    @PostMapping("/add")
    public ResponseEntity<Map<Object, Object>> addNote(@RequestBody Note note, Principal principal){
        Map<Object, Object> res = new HashMap<>();
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        note.setUser(user);
        Note createdNote = noteService.createNote(note);
        res.put(Response.success, true);
        res.put(Response.data, createdNote);
        res.put(Response.message, "Note added successfully");
        return ResponseEntity.ok(res);
    }

    @GetMapping("/recent")
    public ResponseEntity<Map<Object, Object>> getRecentNotes(Principal principal){
        Map<Object, Object> res = new HashMap<>();
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Note> notes = noteService.getTenRecentNotes(user);
        res.put(Response.success, true);
        res.put(Response.data, notes);
        res.put(Response.message, "Recent Notes fetched successfully");
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Map<Object, Object>> deleteNote(@PathVariable Integer noteId){
        Map<Object, Object> res = new HashMap<>();
        noteService.deleteNote(noteId);
        res.put(Response.success, true);
        res.put(Response.data, null);
        res.put(Response.message, "Note deleted successfully");
        return ResponseEntity.ok(res);
    }

}
