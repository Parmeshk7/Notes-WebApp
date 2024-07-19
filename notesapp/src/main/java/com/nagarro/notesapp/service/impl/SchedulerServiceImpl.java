package com.nagarro.notesapp.service.impl;

import com.nagarro.notesapp.model.entity.Note;
import com.nagarro.notesapp.model.entity.User;
import com.nagarro.notesapp.repository.NoteRepository;
import com.nagarro.notesapp.repository.UserRepository;
import com.nagarro.notesapp.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void deleteOldNotes() {
        List<User> users = userRepository.findAll();
        for(User user : users){
            List<Note> userNotes = user.getNotes();
            if(userNotes.size() > 10){
                List<Note> userRecentNotes = noteRepository.findTop10ByUserOrderByCreatedAtDesc(user);
                userNotes.removeAll(userRecentNotes);
                noteRepository.deleteAll(userNotes);
            }
        }
    }

}
