import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Task } from 'src/app/models/Task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task-details',
  templateUrl: './taskdetails.component.html',
  styleUrls: ['./taskdetails.component.css']
})
export class TaskDetailsComponent implements OnInit {
  task: Task | null = null;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log('Route Params:', params);
      const taskId = parseInt(params['taskId'], 10); // Parse as integer
      console.log('Parsed Task ID:', taskId);
      if (!isNaN(taskId)) {
        this.taskService.getTask(taskId).subscribe(
          (task: Task) => {
            this.task = task;
          },
          (error: any) => {
            console.error('Error fetching task details:', error);
          }
        );
      } else {
        console.error('Invalid task ID:', taskId);
      }
    });
  }
}  