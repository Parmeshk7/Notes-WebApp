import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { ShowNotesComponent } from './pages/show-notes/show-notes.component';
import { AddNoteComponent } from './pages/add-note/add-note.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {
    path: "", component: HomeComponent
  },
  {
    path: "login", component: LoginComponent
  },
  {
    path: "signup", component: SignupComponent
  },
  {
    path: "notes", component: ShowNotesComponent, canActivate: [AuthGuard]
  },
  {
    path: "add", component: AddNoteComponent, canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
