import { Component, OnInit } from '@angular/core';
import { Board } from '../../models/Board';
import { BoardService } from '../../services/board.service';

@Component({
  selector: 'app-board',
  templateUrl: './board-list.component.html',
  styleUrls: ['./board-list.component.css']
})
export class BoardComponent implements OnInit {
  boards: Board[] = [];
  router: any;

  constructor(private boardService: BoardService) { }

  ngOnInit(): void {
    this.fetchBoards();
  }

  fetchBoards(): void {
    this.boardService.getAllBoards()
      .subscribe(
        (boards: Board[]) => {
          this.boards = boards;
        },
        (error: any) => {
          console.error('Error fetching boards: ', error);
        }
      );
  }

}
