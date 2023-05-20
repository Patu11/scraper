import {Component, Input, OnInit} from '@angular/core';
import {Episode, Series} from "../../../model/SeriesResponse";

@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.css']
})
export class SeriesComponent implements OnInit {
  @Input()
  series?: Series;

  @Input()
  nextEpisode?: Episode;

  constructor() {
  }

  ngOnInit(): void {
  }

}
