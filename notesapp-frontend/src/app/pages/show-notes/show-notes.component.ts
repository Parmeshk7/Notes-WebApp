import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiResponse } from 'src/app/models/api-response';
import { Note } from 'src/app/models/note';
import { NoteService } from 'src/app/services/note.service';

@Component({
  selector: 'app-show-notes',
  templateUrl: './show-notes.component.html',
  styleUrls: ['./show-notes.component.css']
})
export class ShowNotesComponent implements OnInit {

  notes: Array<Note> = []
  message: string = "";

  constructor(private noteService: NoteService, private router: Router) { }

  ngOnInit(): void {
    this.showNotes();
  }

  showNotes(): void {
    this.noteService.getRecentNotes().subscribe((res: ApiResponse) => {
      if (res.success) {
        this.notes = res.data;
      }
    })
  }

  deleteNote(noteId: Number): void {
    if (confirm("The notw will be deleted permanently, Continue ?")) {
      this.noteService.deleteNote(noteId).subscribe((res: ApiResponse) => {
        if (res.success) {
          this.message = res.message;
          this.showNotes();

        }
      })
    }
  }

}


