import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardAdminComponent } from './board/board-admin/board-admin.component';
import { BoardModeratorComponent } from './board/board-moderator/board-moderator.component';
import { BoardUserComponent } from './board/board-user/board-user.component';
import { GoalAddPanelComponent } from './goal/goal-add-panel/goal-add-panel.component';
import { HomeComponent } from './home/home/home.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MyGoalsComponent } from './goal/my-goals/my-goals.component';
import { NotFoundComponent } from './notFound/not-found/not-found.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { RoutesComponent } from './routes/search/searchRoutes.component';
import { CreateRouteComponent } from './routes/create-route/create-route.component';
import { ViewRouteComponent } from './routes/view-route/view-route.component';
import { WorkoutDashboardComponent } from './workout/workout-dashboard/workout-dashboard.component';
import { CreateWorkoutComponent } from './workout/create-workout/create-workout.component';
import { GoalListPanelComponent } from './goal/goal-list-panel/goal-list-panel.component';
import { EditGoalComponent } from './goal/edit-goal/edit-goal.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'routes/search', component: RoutesComponent },
  { path: 'routes/create', component: CreateRouteComponent },
  { path: 'routes/view/:name', component: ViewRouteComponent },
  { path: 'workout/dashboard', component: WorkoutDashboardComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'goal-add', component: GoalAddPanelComponent },
  { path: 'goal-edit/:id', component: EditGoalComponent },
  { path: 'goal-list', component: GoalListPanelComponent },
  { path: 'myGoals', component: MyGoalsComponent },
  { path: 'workout/create/:date', component: CreateWorkoutComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
