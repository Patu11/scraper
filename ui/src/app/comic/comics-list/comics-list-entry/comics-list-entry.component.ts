import {Component, Input, OnInit} from '@angular/core';
import {CommonService} from "../../../service/common.service";

@Component({
  selector: 'app-comics-list-entry',
  templateUrl: './comics-list-entry.component.html',
  styleUrls: ['./comics-list-entry.component.css']
})
export class ComicsListEntryComponent implements OnInit {

  @Input()
  title: string = '';

  @Input()
  rawTitle: string = '';

  constructor(private commonService: CommonService) {
  }

  onTitleClick() {
    this.commonService.onComicTitleClicked(this.rawTitle);
  }

  ngOnInit(): void {
  }

}
