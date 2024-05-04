import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SprintService } from '../../services/sprint.service';
import { Sprint } from '../../models/Sprint';

@Component({
  selector: 'app-add-sprint',
  templateUrl: './addsprint.component.html',
  styleUrls: ['./addsprint.component.css']
})
export class AddSprintComponent implements OnInit {
  addSprintForm: FormGroup;
  successMessage: string = "";
  errorMessage: string = "";

  constructor(
    private formBuilder: FormBuilder,
    private sprintService: SprintService) {
    this.addSprintForm = this.formBuilder.group({
      name: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.addSprintForm.valid) {
      const sprintData: Sprint = {
        id: 0,
        name: this.addSprintForm.value.name,
        startDate: this.addSprintForm.value.startDate,
        endDate: this.addSprintForm.value.endDate
      };

      this.sprintService.addSprint(sprintData).subscribe(
        response => {
          this.successMessage = "Sprint added successfully.";
          this.addSprintForm.reset();
        },
        error => {
          this.errorMessage = "Error adding sprint. Please try again.";
        }
      );
    }
  }
}
