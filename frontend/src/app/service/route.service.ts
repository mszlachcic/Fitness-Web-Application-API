import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { addCheckpoint, addRoute } from '../state/post.actions';

export interface ICheckpointDto {
  type: string,
  latitude: number,
  longitude: number,
  whichInTurn: number
}

export interface IRouteCreateDto {
  name: string,
  distance: number,
  city: ICityDto,
  date: Date,
  checkpointList: ICheckpointDto[]
}

export interface IRouteDto {
  name: string,
  distance: number,
  city: ICityDto,
  date: Date
}

export interface IRouteWithCheckpointsDto {
  name: string,
  distance: number,
  city: ICityDto,
  date: Date,
  checkpointList: ICheckpointDto[]
}

export interface ICityDto {
  name: string,
  country: ICountryDto
}

export interface ICountryDto {
  name: string
}

@Injectable({
  providedIn: 'root'
})
export class RouteService {
  constructor(private http: HttpClient, private store: Store) {
    this.addAllRoutesToStore()
  }

  checkpoints: ICheckpointDto[] = [];
  routes: IRouteDto[] = [];
  url = 'http://127.0.0.1:8080/routes/'


  getRoutesByCityName(name:string){
    return this.http.get<IRouteDto[]>(`http://localhost:8080/api/routes/getRoutesByCityName?name=${name}`)
  }

  addAllRoutesToStore() {
    this.getAllRoutes().subscribe((res) => {
      for (let i = 0; i < res.length; i++) {
        let route = res[i];
        this.store.dispatch(addRoute({ route }))
        this.routes.push(route)
      }
    }
    )
  }

  getAllRoutes() {
    return this.http.get<IRouteDto[]>(`http://localhost:8080/api/routes/getAllRoutes`);
  }

  createRoute(route: IRouteCreateDto) {
    this.http.post(`http://localhost:8080/api/routes/createRoute`,route).subscribe();
  }

  getRouteByName(name: string){
    return this.http.get<IRouteWithCheckpointsDto>(`http://localhost:8080/api/routes/getRouteByName?name=${name}`);
  }









  // addAllRoutesToStore() {
  //   this.fetchRoute().subscribe(
  //     (res) => {
  //       for (let i = 0; i < res.length; i++) {
  //         let route = res[i];
  //         this.store.dispatch(addRoute({ route }));
  //         this.routes.push(res[i]);
  //       }
  //     }
  //   )
  // }

  // addFetchedCheckpointsToStore(id: number) {
  //   this.fetchCheckpoint(id).subscribe(
  //     (res) => {
  //       for (let i = 0; i < res.length; i++) {
  //         let checkpoint = res[i];
  //         this.store.dispatch(addCheckpoint({ checkpoint }));
  //         this.checkpoints.push(res[i]);
  //       }
  //     }
  //   )
  // }


  // fetchCheckpoint(id: number) {
  //   return this.http.get<ICheckpointDto[]>(`http://127.0.0.1:8080/checkpoints/getCheckpointByRouteId?routeId=${id}`);
  // }

  // fetchRoute() {
  //   return this.http.get<IRouteDto[]>(`${this.url}getAllRoutes`);
  // }
}
