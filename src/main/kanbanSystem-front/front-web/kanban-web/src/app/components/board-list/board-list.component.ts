// BoardComponent
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Board } from '../../models/Board';
import { BoardService } from '../../services/board.service';

@Component({
  selector: 'app-board',
  templateUrl: './board-list.component.html',
  styleUrls: ['./board-list.component.css']
})
export class BoardComponent implements OnInit {
  boards: Board[] = [];

  constructor(private router: Router, private boardService: BoardService) { }

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

  showTasks(boardId: number): void {
    this.router.navigate(['/tasks', 'board', boardId]);
  }

  goToAddBoard(): void {
    this.router.navigate(['/addboard']);
  }

  goToSprint(): void {
    this.router.navigate(['/sprints']);
  }

  deleteBoard(boardId: number): void {
    if (confirm('Are you sure you want to delete this board?')) {
      this.boardService.deleteBoard(boardId)
        .subscribe(
          () => {
            this.fetchBoards();
          
          },
          (error: any) => {
            alert('Board deleted successfully.');
            this.router.navigate(['/boards']);

          }
        );
    }
  }
}
