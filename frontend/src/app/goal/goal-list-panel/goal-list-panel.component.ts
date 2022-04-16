import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { GoalService, IGoalDto, IGoalTypeDto } from '../../service/goal.service';
import { UserService } from '../../service/user.service';
import { AppState, selectGoals, selectGoalTypes } from '../../state/post.selector';

@Component({
  selector: 'app-goal-list-panel',
  templateUrl: './goal-list-panel.component.html',
  styleUrls: ['./goal-list-panel.component.scss']
})
export class GoalListPanelComponent implements OnInit {
  goals: Observable<IGoalDto[]>
  goalTypes: Observable<IGoalTypeDto[]>
  store:Store<AppState>;

  constructor(private userService: UserService, store: Store<AppState>,private goalService: GoalService) { 
    this.store = store;
    this.goals = this.store.select(selectGoals);
    this.goalTypes = this.store.select(selectGoalTypes)
  }

  

  ngOnInit(): void {
  }

}
