import { Component, OnInit } from '@angular/core';
import { GoalService } from '../service/goal.service';
import { TokenStorageService } from '../service/token-storage.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  constructor(private token: TokenStorageService, private goalService: GoalService) { }
  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }
  addGoal(){
    let goal = {
      goalType: {
        id: 1,
        name:"Pompki",
        unit:"Powt"
      },
        value: 10
    }
    // this.goalService.addGoal(goal);
  }
}