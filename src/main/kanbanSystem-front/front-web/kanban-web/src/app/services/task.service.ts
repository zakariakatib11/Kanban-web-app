import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/Task';
import { TaskStatus } from '../models/TaskStatus';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:91/api/tasks';
  
  constructor(private http: HttpClient) { }
  
  getTasksByBoardId(boardId: number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/board/${boardId}`);
  }
  
  updateTaskStatus(taskId: number, status: TaskStatus): Observable<any> {
    return this.http.put(`${this.apiUrl}/${taskId}/status`, { status });
  }
  addTask(task: Task): Observable<Task> {
    return this.http.post<Task>(this.apiUrl, task);
  }
  deleteTask(taskId: number): Observable<any> {
    return this.http.delete(`http://localhost:91/api/tasksDeleted/${taskId}`);
  }
  getTask(taskId: number): Observable<any> {
    return this.http.get<Task>(`http://localhost:91/api/tasksId/${taskId}`);
  }
}
