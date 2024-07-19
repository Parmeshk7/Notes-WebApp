import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/api-response';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  private recentNotesAPI = "http://localhost:8081/api/note/recent";
  private createNoteAPI = "http://localhost:8081/api/note/add";
  private deleteNoteAPI = "http://localhost:8081/api/note";

  constructor(private http: HttpClient) { }

  getRecentNotes(): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.recentNotesAPI);
  }

  createNote(note: {title: string, content: string }): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.createNoteAPI, note);

  }

  deleteNote(noteId: Number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(`${this.deleteNoteAPI}/${noteId}`);
  }



}
