import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Task } from 'src/app/models/Task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  tasks: Task[] = [];

  constructor(private router: Router, 
              private route: ActivatedRoute,
              private taskService: TaskService) { }

  ngOnInit(): void {
    this.fetchTasks();
  }

  fetchTasks(): void {
    const boardId = this.route.snapshot.params['boardId'];
    this.taskService.getTasksByBoardId(boardId)
      .subscribe(
        (tasks: Task[]) => {
          this.tasks = tasks;
        },
        (error: any) => {
          console.error('Error fetching tasks: ', error);
        }
      );
  }
}
