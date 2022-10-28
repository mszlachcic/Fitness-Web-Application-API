import { Component, OnInit } from '@angular/core';
import * as L from 'leaflet';
import { LeafletMouseEvent } from 'leaflet';
import 'leaflet-routing-machine';
import { ICheckpointDto, RouteService } from 'src/app/service/route.service';

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
  selector: 'app-create-route',
  templateUrl: './create-route.component.html',
  styleUrls: ['./create-route.component.scss']
})
export class CreateRouteComponent implements OnInit {
  map!: L.Map;
  latlngs: L.LatLng[] = [];
  routingControl!: L.Routing.Control;
  waypoints: L.Routing.Waypoint[] = [];
  distance:number = 0;

  constructor(private routeService: RouteService) { }

  ngOnInit(): void {
    let map = L.map('map').setView([50.674221, 17.932308], 13);
    tiles.addTo(map)

    map.on('click', (e) => {
      // let marker = L.marker([this.getLatLng(e).lat, this.getLatLng(e).lng]).addTo(map);
      let tmplatlng: L.LatLng;
      tmplatlng = this.getLatLng(e)
      this.latlngs.push(tmplatlng);

      L.Routing.control({
        waypoints: this.latlngs
      }).on('routeselected', (e) =>{
        let route = e.route;
        // let summary = routes[0].summary;
        this.distance = route.summary.totalDistance / 1000;
        console.log(this.distance)
      })
      .addTo(map)
    });
  }

  getLatLng(e: L.LeafletEvent) {
    let e2 = <LeafletMouseEvent>e;
    return e2.latlng;
  }

  createRoute(nameInput:string, countryInput:string, cityInput: string) {

    let checkpoints = [{
      type: "START",
      latitude: this.latlngs[0].lat,
      longitude: this.latlngs[0].lng,
      whichInTurn: 1
    }]

    for (let i = 1; i < this.latlngs.length - 1; i++) {
      let tmpCheckpoint = {
        type: "MID",
        latitude: this.latlngs[i].lat,
        longitude: this.latlngs[i].lng,
        whichInTurn: i + 1
      }
      checkpoints.push(tmpCheckpoint)
    }

    let lastCheckpoint = {
      type: "END",
      latitude: this.latlngs[this.latlngs.length-1].lat,
      longitude: this.latlngs[this.latlngs.length-1].lng,
      whichInTurn: this.latlngs.length
    }
    checkpoints.push(lastCheckpoint)

    let route = {
      name: nameInput,
      distance: this.distance,
      city: {
        name: cityInput,
        country: {
          name: countryInput
        }
      },
      date: new Date(),
      checkpointList: checkpoints
    }
    console.log(route);
    this.routeService.createRoute(route)

  }

}
const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  maxZoom: 15,
  minZoom: 7,
  attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
});
