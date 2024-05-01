import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardComponent } from './components/board-list/board-list.component';

const routes: Routes = [
  { path:'',redirectTo: 'login' ,pathMatch: 'full' },
  { path:'boards', component:BoardComponent},
//  { path:'**', component:LoginComponent},
 // { path:'login', component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
