import { Component, OnInit } from '@angular/core';
import { Sprint } from 'src/app/models/Sprint';
import { SprintService } from 'src/app/services/sprint.service';

@Component({
  selector: 'app-sprint',
  templateUrl: './sprint.component.html',
  styleUrls: ['./sprint.component.css']
})
export class SprintComponent implements OnInit {
  sprints: Sprint[] = [];
  alertMessage: string = '';

  constructor(private sprintService: SprintService) { }

  ngOnInit(): void {
    this.fetchSprints();
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

  deleteSprint(sprintId: number): void {
    if (confirm('Are you sure you want to delete this sprint?')) {
      this.sprintService.deleteSprint(sprintId).subscribe(
        () => {
          // Remove the sprint from the local array
          this.sprints = this.sprints.filter(sprint => sprint.id !== sprintId);
          // Reset the alert message
          this.alertMessage = '';
        },
        (error: any) => {
          console.error('Error deleting sprint: ', error);
          // Set the alert message
          this.alertMessage = 'Error deleting sprint. Please try again.';
        }
      );
    }
  }
}
