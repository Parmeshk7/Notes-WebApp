import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiResponse } from 'src/app/models/api-response';
import { NoteService } from 'src/app/services/note.service';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css']
})
export class AddNoteComponent implements OnInit {

  content:string = ""

  constructor(private noteService: NoteService, private router: Router) { }

  ngOnInit(): void {
  }


  handleAddNote(noteData: NgForm): void {
    if(noteData.valid && this.content.length <= 500){
      this.noteService.createNote({title: noteData.value.title,  content: noteData.value.content}).subscribe((res: ApiResponse) => {
        if(res.success){
          this.router.navigate(['/notes']);
        }
      })
      
    }
    else{
      Object.values(noteData.controls).forEach(control => {
        control.markAsTouched();
      });
    }
  }

}
