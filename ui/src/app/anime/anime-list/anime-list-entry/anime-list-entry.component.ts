import {Component, Input} from '@angular/core';
import {CommonService} from "../../../service/common.service";

@Component({
  selector: 'app-anime-list-entry',
  templateUrl: './anime-list-entry.component.html',
  styleUrls: ['./anime-list-entry.component.css']
})
export class AnimeListEntryComponent {
  @Input()
  title: string = '';

  @Input()
  rawTitle: string = '';

  constructor(private commonService: CommonService) {
  }

  onTitleClick() {
    this.commonService.onAnimeTitleClicked(this.rawTitle);
  }
}
