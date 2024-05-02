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

  constructor(private sprintService: SprintService) { }

  ngOnInit(): void {
    this.fetchSprints();
  }

  fetchSprints(): void {
    this.sprintService.getAllSprints()
      .subscribe(
        (sprints: Sprint[]) => {
          this.sprints = sprints;
        },
        (error: any) => {
          console.error('Error fetching sprints: ', error);
        }
      );
    }
}
