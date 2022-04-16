import { createAction, props } from "@ngrx/store";
import { IGoalDto, IGoalTypeDto } from "../service/goal.service";
import { IPostDto} from "../service/post.service";
import { ICheckpointDto, IRouteDto } from "../service/route.service";


export const addPost = createAction('[post] Add all posts', props<{ post:IPostDto}>());
export const addRoute = createAction('[route] Add all routes',props<{route:IRouteDto}>());
export const addCheckpoint = createAction('[checkpoint] Add all checkpoints',props<{checkpoint:ICheckpointDto}>());
export const addGoalType = createAction('[goalType] Add all goalTypes',props<{goalType:IGoalTypeDto}>());
export const addGoal = createAction('[goal] Add all goals',props<{goal:IGoalDto}>());