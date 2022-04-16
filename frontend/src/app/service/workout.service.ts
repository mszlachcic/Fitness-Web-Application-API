import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenStorageService } from './token-storage.service';

export interface IWorkoutDto {
  name:string,
  beginDate: Date,
  duration: number,
  activity:string,
  user: IUserDto
}

export interface IWorkoutDto2 {
  name:string,
  beginDate: Date,
  duration: number,
  activity:string,
  user: IUserDto
}

export interface IUserDto{
  username: string
}

@Injectable({
  providedIn: 'root'
})

export class WorkoutService {

  constructor(private http: HttpClient, private token:TokenStorageService) { }

  getWorkoutsByUsername(){
    let username = this.token.getUser().username;
    return this.http.get<IWorkoutDto2[]>(`http://localhost:8080/api/workout/getWorkoutsByUsername?username=${username}`);
  }

  addWorkout(workout: IWorkoutDto) {
    this.http.post<any>(`http://localhost:8080/api/workout/addWorkout`, workout).subscribe();
  }
}
