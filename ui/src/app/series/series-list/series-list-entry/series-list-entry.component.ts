import {Component, Input, OnInit} from '@angular/core';
import {CommonService} from "../../../service/common.service";
import {SeriesService} from "../../../service/series.service";

@Component({
  selector: 'app-series-list-entry',
  templateUrl: './series-list-entry.component.html',
  styleUrls: ['./series-list-entry.component.css']
})
export class SeriesListEntryComponent implements OnInit {
  title: string = '';

  @Input()
  rawTitle: string = '';

  constructor(private commonService: CommonService, private seriesService: SeriesService) {
  }

  onTitleClick() {
    this.commonService.onSeriesTitleClicked(this.rawTitle);
  }

  ngOnInit(): void {
    this.seriesService.getTitle(this.rawTitle).subscribe({
      next: (response) => this.title = response,
      error: (error) => console.log(error)
    })
  }
}
