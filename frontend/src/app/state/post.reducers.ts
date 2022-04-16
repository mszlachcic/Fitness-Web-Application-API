import { Action, createReducer, on } from "@ngrx/store";
import { IGoalDto, IGoalTypeDto } from "../service/goal.service";
import { IPostDto } from "../service/post.service";
import { ICheckpointDto, IRouteDto } from "../service/route.service";
import { addCheckpoint, addGoal, addGoalType, addPost, addRoute } from "./post.actions";

export const initialState: IPostDto[] = [];
export const routeInitialState: IRouteDto[] = [];
export const checkpointInitialState: ICheckpointDto[] = [];
export const goalTypeInitialState: IGoalTypeDto[] = [];
export const goalInitialState: IGoalDto[] = [];

const postReducer = createReducer(
    initialState,
    on(addPost, (state, {post}) => {
        return [...state,post]
    })
)

const routeReducer = createReducer(
    routeInitialState,
    on(addRoute, (state, {route}) => {
        return [...state,route]
    })
)

const checkpointReducer = createReducer(
    checkpointInitialState,
    on(addCheckpoint,(state,{checkpoint}) => {
        return[...state,checkpoint]
    })
)

const goalTypeReducer = createReducer(
    goalTypeInitialState,
    on(addGoalType,(state,{goalType}) => {
        return[...state,goalType]
    })
)

const goalReducer = createReducer(
    goalInitialState,
    on(addGoal,(state,{goal}) => {
        return[...state,goal]
    })
)

export function checkpointReducerr(state:ICheckpointDto[] | undefined, action: Action){
    return checkpointReducer(state,action);
}

export function reducer(state: IPostDto[] | undefined, action:Action){
    return postReducer(state,action);
}

export function routeReducerr(state: IRouteDto[] | undefined, action:Action){
    return routeReducer(state,action);
}

export function goalTypeReducerr(state: IGoalTypeDto[] |undefined, action: Action){
    return goalTypeReducer(state,action);
}

export function goalReducerr(state: IGoalDto[] |undefined, action: Action){
    return goalReducer(state,action);
}