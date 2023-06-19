import {Component, Input, OnInit} from '@angular/core';
import {CommonService} from "../../../service/common.service";

@Component({
  selector: 'app-series-list-entry',
  templateUrl: './series-list-entry.component.html',
  styleUrls: ['./series-list-entry.component.css']
})
export class SeriesListEntryComponent implements OnInit {
  @Input()
  title: string = '';

  @Input()
  rawTitle: string = '';

  constructor(private commonService: CommonService) {
  }

  onTitleClick() {
    this.commonService.onSeriesTitleClicked(this.rawTitle);
  }

  ngOnInit(): void {
  }
}
