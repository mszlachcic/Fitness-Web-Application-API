import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { addGoal, addGoalType } from '../state/post.actions';
import { TokenStorageService } from './token-storage.service';

export interface IGoalDto {
  goalType: IGoalTypeDto,
  valueToReach: number,
  valueProgress:number,
  status:string
}

export interface IGoalTypeDto {
  id: number,
  name: string,
  unit: string
}

@Injectable({
  providedIn: 'root'
})

export class GoalService {

  constructor(private http: HttpClient, private store: Store, private token: TokenStorageService) {
    this.addAllGoalTypesToStore();
    this.addUserGoalsToStore();
  }

  goalTypes: IGoalTypeDto[] = [];
  goals: IGoalDto[] = [];
  url = "127.0.0.1:8080/api/goals"

  addAllGoalTypesToStore() {
    this.getGoalTypes().subscribe(
      (res) => {
        for (let i = 0; i < res.length; i++) {
          let goalType = res[i];
          this.store.dispatch(addGoalType({ goalType }));
          this.goalTypes.push(res[i]);
        }
      }
    )
  }

  addUserGoalsToStore() {
    this.getUserGoals().subscribe(
      (res) => {
        for(let i = 0; i < res.length; i++) {
          let goal = res[i];
          this.store.dispatch(addGoal({goal}));
          this.goals.push(res[i]);
        }
      }
    )
  }
  
  addGoal(goal: IGoalDto) {
    let userId = this.token.getUser().id;
    this.http.post<any>(`http://localhost:8080/api/goals/addGoal?userId=${userId}`, goal).subscribe();
  }

  getGoalTypes() {
    return this.http.get<IGoalTypeDto[]>(`http://localhost:8080/api/goalTypes/getGoalTypes`);
  }

  getUserGoals() {
    let username = this.token.getUser().username;
    return this.http.get<IGoalDto[]>(`http://localhost:8080/api/users/getGoalsByUsername?username=${username}`)
  }

  editGoal(newValueProgress:number,id:number){
    let body = {};
    this.http.put(`http://localhost:8080/api/goals/editGoalById?newValueProgress=7&id=2`,body).subscribe();
  }
}
