import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BoardDTO } from 'src/app/models/BoardDTO';
import { BoardService } from 'src/app/services/board.service';

@Component({
  selector: 'app-addboard',
  templateUrl: './addboard.component.html',
  styleUrls: ['./addboard.component.css']
})
export class AddboardComponent implements OnInit {
  boardForm: FormGroup;
  successMessage: string = "";
  errorMessage: string = "";

  constructor(
    private formBuilder: FormBuilder,
    private boardService: BoardService,
    private router: Router
  ) {
    this.boardForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.boardForm.valid) {
      const boardData: BoardDTO = new BoardDTO(
        this.boardForm.value.name,
        this.boardForm.value.description,
        new Date()
      );

      this.boardService.addBoard(boardData).subscribe(
        response => {
          this.successMessage = "Board added successfully.";
          this.boardForm.reset();
          this.router.navigate(['/boards']);
        },
        error => {
          this.errorMessage = "Error adding board. Please try again.";
        }
      );
    }
  }
}
