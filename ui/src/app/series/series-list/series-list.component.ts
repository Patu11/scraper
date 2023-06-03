import {Component, OnInit} from '@angular/core';
import {SeriesService} from "../../service/series.service";
import {UrlTitle} from "../../model/UrlTitle";

@Component({
  selector: 'app-series-list',
  templateUrl: './series-list.component.html',
  styleUrls: ['./series-list.component.css']
})
export class SeriesListComponent implements OnInit {
  urlTitles: UrlTitle[] = [];
  showError: boolean = false;

  constructor(private seriesService: SeriesService) {
  }

  ngOnInit(): void {
    this.seriesService.getAllTitles().subscribe(
      (response) => {
        this.urlTitles = response;
        this.showError = false;
      },
      (error) => {
        this.showError = true;
      }
    )
  }
}
