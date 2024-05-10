import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BoardComponent } from './components/board-list/board-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { TaskComponent } from './components/task/task.component';
import { SprintComponent } from './components/sprint/sprint.component';
import { AddSprintComponent } from './components/addsprint/addsprint.component';
import { AddtaskComponent } from './components/addtask/addtask.component';

import { TaskDetailsComponent } from './components/taskdetails/taskdetails.component';
import { AddboardComponent } from './components/addboard/addboard.component';

@NgModule({
  declarations: [
    AppComponent,
    BoardComponent,
    HomeComponent,
    TaskComponent,
    SprintComponent,
AddboardComponent,
    AddSprintComponent,
    AddtaskComponent,
    TaskDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,    
    HttpClientModule
  
 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
