import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { GoalService, IGoalTypeDto } from '../../service/goal.service';
import { AppState, selectGoalTypes } from '../../state/post.selector';

@Component({
  selector: 'app-goal-add-panel',
  templateUrl: './goal-add-panel.component.html',
  styleUrls: ['./goal-add-panel.component.scss']
})
export class GoalAddPanelComponent implements OnInit {

  goalTypes: Observable<IGoalTypeDto[]>;
  store:Store<AppState>;
  selected = '';

  constructor(store:Store<AppState>, private goalService: GoalService) { 
    this.store = store;
    this.goalTypes = this.store.select(selectGoalTypes)
  } 

  ngOnInit(): void {

  }

  addGoal(){
    let selectedGoalType = JSON.parse(JSON.stringify(this.selected))
    let goal = {
      goalType:{
        id: selectedGoalType.id,
        name: selectedGoalType.name,
        unit: selectedGoalType.unit
      },
      valueToReach: parseFloat((<HTMLInputElement>document.getElementById("valueToReach")).value),
      valueProgress: 0,
      status: 'IN_PROGRESS'
    }
    this.goalService.addGoal(goal);
  }
}
