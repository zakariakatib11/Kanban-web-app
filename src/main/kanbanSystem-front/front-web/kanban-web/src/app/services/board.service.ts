import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Board } from '../models/Board';

@Injectable({
  providedIn: 'root'
})
export class BoardService {
  private baseUrl = 'http://localhost:91/api/boards';

  constructor(private http: HttpClient) { }

  getAllBoards(): Observable<Board[]> {
    return this.http.get<Board[]>(this.baseUrl);
  }

  getBoardById(id: number): Observable<Board> {
    return this.http.get<Board>(`${this.baseUrl}/${id}`);
  }

  createBoard(board: Board): Observable<Board> {
    return this.http.post<Board>(this.baseUrl, board);
  }

  deleteBoard(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
