import {Component, OnInit} from '@angular/core';
import {CommonService} from "../../service/common.service";
import {ShowService} from "../../service/show.service";
import {Episode, Show} from "../../model/Show";

@Component({
  selector: 'app-show-renderer',
  templateUrl: './show-renderer.component.html',
  styleUrls: ['./show-renderer.component.css']
})
export class ShowRendererComponent implements OnInit {
  show?: Show;
  nextEpisode?: Episode;
  loading: boolean = false;

  constructor(private commonService: CommonService, private showService: ShowService) {
  }

  getSeriesResponse(rawTitle: string) {
    this.loading = true;
    this.showService.getSeries(rawTitle).subscribe((response) => {
      this.show = response;
      this.loading = false;
    });

    this.showService.getNextEpisode(rawTitle).subscribe({
      next: (response) => this.nextEpisode = response,
      error: () => this.nextEpisode = {title: 'Unknown', premiere: 'Unknown'}
    });
  }

  ngOnInit(): void {
    this.commonService.clickedSeriesTitle.subscribe((data) => this.getSeriesResponse(data))
  }

}
