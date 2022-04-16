import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GoalService } from 'src/app/service/goal.service';

@Component({
  selector: 'app-edit-goal',
  templateUrl: './edit-goal.component.html',
  styleUrls: ['./edit-goal.component.scss']
})
export class EditGoalComponent implements OnInit {

  stringId!: string;
  id:number;

  constructor(private goalService:GoalService,private activatedRoute: ActivatedRoute) {
    this.activatedRoute.url.subscribe(name =>
      this.stringId = name[2].path)
      this.id = parseInt(this.stringId);
   }

  ngOnInit(): void {
  }


  saveGoal(){
    let valueToReach = parseFloat((<HTMLInputElement>document.getElementById("valueToReach")).value);
     this.goalService.editGoal(valueToReach,this.id);
  }
}
