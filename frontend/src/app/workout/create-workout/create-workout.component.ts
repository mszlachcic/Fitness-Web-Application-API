import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { concat } from 'rxjs';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { WorkoutService } from 'src/app/service/workout.service';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.scss']
})
export class CreateWorkoutComponent implements OnInit {


  selected = 'RUNNING'
  date!: Date;

  constructor(private workoutService: WorkoutService, private tokenService: TokenStorageService,private activatedRoute: ActivatedRoute) { 
    this.activatedRoute.url.subscribe(uri =>{
      this.date = new Date(uri[2].path);
    })
  }

  ngOnInit(): void {
  }

  addWorkout(nameInput: string, timeInput: string, hourInput: string, minuteInput: string, secondInput: string) {
    let tmpHour = Number.parseInt(hourInput)
    let tmpMinute = Number.parseInt(minuteInput)
    let tmpSecond = Number.parseInt(secondInput)

    this.date.setHours(Number.parseInt(hourInput))
    this.date.setMinutes(Number.parseInt(minuteInput))
    this.date.setSeconds(Number.parseInt(secondInput))
    
    let tmpDuration = tmpHour*3600 + tmpMinute*60 + tmpSecond;


    console.log(this.selected)

    let workout = {
      name: nameInput,
      beginDate: this.date,
      duration: tmpDuration,
      activity: this.selected,
      user: {
        username: this.tokenService.getUser().username
      }
    }

    // console.log(workout)

    this.workoutService.addWorkout(workout);
  }

}
