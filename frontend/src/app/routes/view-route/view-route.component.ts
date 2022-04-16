import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { IRouteWithCheckpointsDto, RouteService } from 'src/app/service/route.service';
import { AppState } from 'src/app/state/post.selector';
import * as L from 'leaflet';
import 'leaflet-routing-machine';
import { Observable } from 'rxjs';

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
  selector: 'app-view-route',
  templateUrl: './view-route.component.html',
  styleUrls: ['./view-route.component.scss']
})
export class ViewRouteComponent implements OnInit {

  name!: string
  route:Observable<IRouteWithCheckpointsDto>;
  latlngs: L.LatLng[] = [];
  map!: L.Map;

  constructor(private activatedRoute: ActivatedRoute,private routeService: RouteService,store:Store<AppState>) { 
    this.activatedRoute.url.subscribe(name =>
      this.name = name[2].path)
      this.route = routeService.getRouteByName(this.name)
  }

  ngOnInit(): void {
    this.route.subscribe(route => {
      this.map = L.map('map').setView([route.checkpointList[0].latitude, route.checkpointList[0].longitude], 13);
    tiles.addTo(this.map)
    })

    this.route.subscribe( data => {
      let checkpointList = data.checkpointList;

      for (let i = 0; i < checkpointList.length; i++) {
        this.latlngs.push(new L.LatLng(checkpointList[i].latitude,checkpointList[i].longitude));
      }
      L.Routing.control({
        waypoints: this.latlngs
      }).addTo(this.map);
    })

    
  }

}
const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  maxZoom: 15,
  minZoom: 7,
  attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
});