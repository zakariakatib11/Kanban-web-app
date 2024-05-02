import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:91/api';

  constructor(private http: HttpClient) { }

  getTasksByBoardId(boardId: number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/tasks/board/${boardId}`);
  }
}
