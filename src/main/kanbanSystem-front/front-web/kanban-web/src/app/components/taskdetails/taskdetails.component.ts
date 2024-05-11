import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Task } from 'src/app/models/Task';
import { Sprint } from 'src/app/models/Sprint';
import { User } from 'src/app/models/User';
import { TaskService } from 'src/app/services/task.service';
import { SprintService } from 'src/app/services/sprint.service';
import { UserService } from 'src/app/services/user.service';
import { Board } from 'src/app/models/Board';
import { BoardService } from 'src/app/services/board.service';
import { LoginService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-task-details',
  templateUrl: './taskdetails.component.html',
  styleUrls: ['./taskdetails.component.css']
})
export class TaskDetailsComponent implements OnInit {
  task: Task | null = null;
  sprints: Sprint[] = [];
  users: User[] = [];
  selectedSprintIds: number[] = [];
  selectedUserIds: number[] = [];
  boards: Board[] = [];
  userRole: string = ''; // Variable to store the user's role


  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    private sprintService: SprintService,
    private userService: UserService,
    private router: Router,
    private boardService: BoardService,
    private Loginservice: LoginService
  ) {}

  ngOnInit(): void {
    this.fetchBoards();
    this.userRole = this.Loginservice.getUserRole();
    this.route.params.subscribe(params => {
      const taskId = +params['taskId'];
      this.taskService.getTask(taskId).subscribe(
        (task: Task) => {
          this.task = task;
          this.selectedSprintIds = task.sprints.map(s => s.id);
          this.selectedUserIds = task.users.map(u => u.id);
        },
        (error: any) => {
          console.error('Error fetching task details:', error);
        }
      );
    });

    this.sprintService.getAllSprints().subscribe(
      (sprints: Sprint[]) => {
        this.sprints = sprints;
      },
      (error: any) => {
        console.error('Error fetching sprints:', error);
      }
    );

    this.userService.getAllUsers().subscribe(
      (users: User[]) => {
        this.users = users;
      },
      (error: any) => {
        console.error('Error fetching users:', error);
      }
    );
  }

  updateTask(): void {
    if (this.task) {
      this.task.sprints = this.sprints.filter(s => this.selectedSprintIds.includes(s.id));
      this.task.users = this.users.filter(u => this.selectedUserIds.includes(u.id));
      
      this.taskService.updateTask(this.task).subscribe(
        (updatedTask: Task) => {
          console.log('Task updated successfully:', updatedTask);
          this.router.navigate(['/tasks/board', this.task?.board.id]);
        },
        (error: any) => {
          console.error('Error updating task:', error);
        }
      );
    }
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

