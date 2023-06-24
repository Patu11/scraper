import {Component, Input, OnInit} from '@angular/core';
import {CommonService} from "../../../service/common.service";
import {ShowService} from "../../../service/show.service";

@Component({
  selector: 'app-show-list-entry',
  templateUrl: './show-list-entry.component.html',
  styleUrls: ['./show-list-entry.component.css']
})
export class ShowListEntryComponent implements OnInit {
  title: string = '';

  @Input()
  rawTitle: string = '';

  showSpinner: boolean = true;

  constructor(private commonService: CommonService, private showService: ShowService) {
  }

  onTitleClick() {
    this.commonService.onSeriesTitleClicked(this.rawTitle);
  }

  onDeleteClick() {
    console.log(this.rawTitle);
    this.commonService.onDeleteEntryClick(this.rawTitle);
  }

  ngOnInit(): void {
    this.showService.getTitle(this.rawTitle).subscribe({
      next: (response) => {
        this.title = response;
        this.showSpinner = false;
      },
      error: (error) => console.log(error)
    })
  }
}
