  import { Injectable } from '@angular/core';
  import { HttpClient } from '@angular/common/http';
  import { Observable } from 'rxjs';
  import { Board } from '../models/Board';
  import { User } from '../models/User';

  @Injectable({
    providedIn: 'root'
  })
  export class BoardService {
    private baseUrl = 'http://localhost:91/api/boards';

    constructor(private http: HttpClient) {}

    getAllBoards(): Observable<Board[]> {
      return this.http.get<Board[]>(this.baseUrl);
    }
    addBoard(board: Board): Observable<any> {
      return this.http.post<any>('http://localhost:91/api/boards', board);
    }
    getUsers(): Observable<User[]> {
      return this.http.get<User[]>('http://localhost:91/Allusers');
    }
  }
