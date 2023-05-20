import {Component, OnInit} from '@angular/core';
import {CommonService} from "../../service/common.service";
import {SeriesService} from "../../service/series.service";
import {Episode, Series, SeriesResponse} from "../../model/SeriesResponse";

@Component({
  selector: 'app-series-renderer',
  templateUrl: './series-renderer.component.html',
  styleUrls: ['./series-renderer.component.css']
})
export class SeriesRendererComponent implements OnInit {
  series?: Series;
  nextEpisode?: Episode;
  loading: boolean = false;

  constructor(private commonService: CommonService, private seriesService: SeriesService) {
  }

  getSeriesResponse(rawTitle: string) {
    this.loading = true;
    this.seriesService.getSeries(rawTitle).subscribe((response) => {
      const seriesResponse = response as SeriesResponse;
      this.series = seriesResponse.series;
      this.loading = false;
    });

    this.seriesService.getNextEpisode(rawTitle).subscribe((response) => {
      this.nextEpisode = response as Episode;
    })
  }

  ngOnInit(): void {
    this.commonService.clickedSeriesTitle.subscribe((data) => this.getSeriesResponse(data))
  }

}
