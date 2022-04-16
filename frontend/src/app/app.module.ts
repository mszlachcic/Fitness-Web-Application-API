import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home/home.component';
import { NotFoundComponent } from './notFound/not-found/not-found.component';
import { MatCardModule } from '@angular/material/card';
import { RecommendedPostsDashboardComponent } from './home/recommended-posts-dashboard/recommended-posts-dashboard.component';
import { CardComponent } from './home/recommended-posts-dashboard/card/card.component';
import { HttpClientModule } from '@angular/common/http';
import { Store, StoreModule } from '@ngrx/store';
import { RoutesComponent } from './routes/search/searchRoutes.component';
import { checkpointReducerr, goalReducerr, goalTypeReducerr, reducer, routeReducerr } from './state/post.reducers';
import { MainBackgroundComponent } from './home/main-background/main-background.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { CookieService } from 'ngx-cookie-service';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board/board-admin/board-admin.component';
import { BoardModeratorComponent } from './board/board-moderator/board-moderator.component';
import { BoardUserComponent } from './board/board-user/board-user.component';
import { FormsModule } from '@angular/forms';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { GoalAddPanelComponent } from './goal/goal-add-panel/goal-add-panel.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatMenuModule} from '@angular/material/menu';
import {MatSelectModule} from '@angular/material/select';
import { MyGoalsComponent } from './goal/my-goals/my-goals.component';
import { GoalListPanelComponent } from './goal/goal-list-panel/goal-list-panel.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { CreateRouteComponent } from './routes/create-route/create-route.component';
import { WorkoutDashboardComponent } from './workout/workout-dashboard/workout-dashboard.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { ViewRouteComponent } from './routes/view-route/view-route.component';
import { CommonModule } from '@angular/common';
import { FlatpickrModule } from 'angularx-flatpickr';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { CreateWorkoutComponent } from './workout/create-workout/create-workout.component';
import { DatePipe } from '@angular/common';
import { EditGoalComponent } from './goal/edit-goal/edit-goal.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    RecommendedPostsDashboardComponent,
    CardComponent,
    RoutesComponent,
    MainBackgroundComponent,
    LoginPageComponent,
    RegisterPageComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    GoalAddPanelComponent,
    MyGoalsComponent,
    GoalListPanelComponent,
    CreateRouteComponent,
    ViewRouteComponent,
    WorkoutDashboardComponent,
    CreateWorkoutComponent,
    EditGoalComponent
  ],
  imports: [
    StoreModule.forRoot({posts:reducer,routes:routeReducerr,checkpoints:checkpointReducerr,goalTypes:goalTypeReducerr,goals:goalReducerr}),
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
    LeafletModule,
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatRadioModule,
    MatMenuModule,
    MatSelectModule,
    MatProgressBarModule,
    NgbModalModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    FlatpickrModule.forRoot(),
  ],
  providers: [
    Store,
    authInterceptorProviders,
    CookieService,
    DatePipe
  ],
  bootstrap: [AppComponent],
  exports:[WorkoutDashboardComponent]
})
export class AppModule { }
