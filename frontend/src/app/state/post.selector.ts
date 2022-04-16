import { IGoalDto, IGoalTypeDto } from "../service/goal.service";
import { IPostDto, IUserDto } from "../service/post.service";
import { ICheckpointDto, IRouteDto } from "../service/route.service";

export interface AppState { 
    posts: IPostDto[];
    routes: IRouteDto[];
    checkpoints: ICheckpointDto[];
    goalTypes: IGoalTypeDto[];
    goals: IGoalDto[];
}

export const selectPosts = (state: AppState) => state.posts;
export const selectRoutes = (state: AppState) => state.routes; 
export const selectCheckpoints = (state: AppState) => state.checkpoints;
export const selectGoalTypes = (state: AppState) => state.goalTypes;
export const selectGoals = (state: AppState) => state.goals;