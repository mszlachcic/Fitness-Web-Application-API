import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import * as L from 'leaflet';
import 'leaflet-routing-machine';
import { Observable } from 'rxjs';
import { ICheckpointDto, IRouteDto, RouteService } from 'src/app/service/route.service';
import { AppState, selectCheckpoints, selectRoutes } from 'src/app/state/post.selector';

const iconRetinaUrl = 'assets/marker-icon-2x.png';
const iconUrl = 'assets/marker-icon.png';
const shadowUrl = 'assets/marker-shadow.png';
const iconDefault = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
L.Marker.prototype.options.icon = iconDefault;

@Component({
  selector: 'app-searchRoutes',
  templateUrl: './searchRoutes.component.html',
  styleUrls: ['./searchRoutes.component.scss']
})

export class RoutesComponent implements OnInit {
  
  routes: Observable<IRouteDto[]> | undefined;
  checkpoints: Observable<ICheckpointDto[]> | undefined;
  store:Store<AppState>;

  constructor(store:Store<AppState>,private routeService: RouteService) { 
    this.store = store;
  }

  findByCityName(cityInput:string){
    this.routes = this.routeService.getRoutesByCityName(cityInput);
  }
  
  // onClick(id:number){ 
  //   console.log("1")
  //   this.routeService.addFetchedCheckpointsToStore(id)
  //   console.log("2")
  //   let lat = this.store.select(selectCheckpoints).subscribe(
  //     (res) => {
  //       console.log("3")
  //       console.log("lat: " + res[0].latitude + "lon: " + res[0].longitude)
  //       let map = L.map('map').setView([res[0].latitude,res[0].longitude],15);
  //       console.log("4")
  //       tiles.addTo(map);
  //       console.log("5")
  //       for (let i = 0; i < res.length; i++){
  //         L.Routing.control({
  //           waypoints: [
  //             L.latLng(res[i].latitude, res[i].longitude),
  //             L.latLng(res[i+1].latitude, res[i+1].longitude)
  //           ]
  //         }).addTo(map);
  //       }
  //     }
  //   )
  // }

  ngOnInit(): void {
  }
}
const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 15,
      minZoom: 7,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });