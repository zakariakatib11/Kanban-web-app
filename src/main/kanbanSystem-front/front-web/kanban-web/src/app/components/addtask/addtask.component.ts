import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'; 
import { Task } from 'src/app/models/Task';
import { Board } from 'src/app/models/Board';
import { Sprint } from 'src/app/models/Sprint';
import { User } from 'src/app/models/User';
import { TaskService } from 'src/app/services/task.service';
import { BoardService } from 'src/app/services/board.service';
import { SprintService } from 'src/app/services/sprint.service';
import { UserService } from 'src/app/services/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {
  @ViewChild('taskForm') taskForm!: NgForm;

  boards: Board[] = [];
  selectedBoardId: number | null = null;
  selectedBoardName: string | null = null;
  sprints: Sprint[] = [];
  selectedSprintIds: number[] = [];
  users: User[] = [];
  selectedUserIds: number[] = [];
  

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    private boardService: BoardService,
    private sprintService: SprintService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchBoards();
    this.fetchSprints();
    this.fetchUsers();
    this.route.params.subscribe(params => {
      this.selectedBoardId = +params['boardId'];
    });
  }

  fetchBoards(): void {
    this.boardService.getAllBoards().subscribe(
      (boards: Board[]) => {
        this.boards = boards;
        if (this.selectedBoardId !== null && this.selectedBoardId !== undefined) {
          const selectedBoard = this.boards.find(board => board.id === this.selectedBoardId);
          if (selectedBoard) {
            this.selectedBoardName = selectedBoard.name;
          } else {
            console.error('Selected board not found');
          }
        }
      },
      (error: any) => {
        console.error('Error fetching boards: ', error);
      }
    );
  }
  

  fetchSprints(): void {
    this.sprintService.getAllSprints().subscribe(
      (sprints: Sprint[]) => {
        this.sprints = sprints;
      },
      (error: any) => {
        console.error('Error fetching sprints: ', error);
      }
    );
  }

  fetchUsers(): void {
    this.userService.getAllUsers().subscribe(
      (users: User[]) => {
        this.users = users;
      },
      (error: any) => {
        console.error('Error fetching users: ', error);
      }
    );
  }

  onSubmit(): void {
    console.log('Selected board ID:', this.selectedBoardId);
    if (this.selectedBoardId === null || this.selectedBoardId === undefined) {
      console.error('Selected board ID is null or undefined');
      return;
    }

    const selectedBoard = this.boards.find(board => board.id === this.selectedBoardId);  
    if (!selectedBoard) {
      console.error('Selected board not found');
      return;
    }
  
    console.log('Selected board:', selectedBoard);
  
    const selectedSprints = this.sprints.filter(sprint => this.selectedSprintIds.includes(sprint.id));
    const selectedUsers = this.users.filter(user => this.selectedUserIds.includes(user.id));
  
    const newTask: Task = new Task(
      0,
      this.taskForm.value.name,
      this.taskForm.value.description,
      this.taskForm.value.status,
      this.taskForm.value.estimation,
      selectedBoard,
      selectedUsers,
      selectedSprints
    );
  
    this.taskService.addTask(newTask).subscribe(
      (response: Task) => {
        console.log('Task added successfully:', response);
        this.taskForm.resetForm();
        this.selectedSprintIds = [];
        this.selectedUserIds = [];
        this.router.navigate(['/tasks/board',this.selectedBoardId]);
      },
      (error: any) => {
        console.error('Error adding task:', error);
      }
    );
  }
}
