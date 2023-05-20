import {Component, OnInit} from '@angular/core';
import {SeriesService} from "../../service/series.service";

@Component({
  selector: 'app-series-list',
  templateUrl: './series-list.component.html',
  styleUrls: ['./series-list.component.css']
})
export class SeriesListComponent implements OnInit {
  titlesMap: Map<string, string> = new Map();

  constructor(private seriesService: SeriesService) {
  }

  mapTitlesResponse(titlesResponse: string[]) {
    titlesResponse.forEach(input => {
      let split = input.split(":")
      let key = split[0]
      let value = split[1]
      this.titlesMap.set(key, value);
    });
  }

  ngOnInit(): void {
    this.seriesService.getAllTitles().subscribe(
      (response) => this.mapTitlesResponse(response as string[])
    )
  }

}
