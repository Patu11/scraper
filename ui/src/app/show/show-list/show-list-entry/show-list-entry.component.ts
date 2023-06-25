import {Component, Input, OnInit} from '@angular/core';
import {CommonService} from "../../../service/common.service";
import {ShowService} from "../../../service/show.service";
import {ScrapingProperty} from "../../../model/ScrapingProperty";

@Component({
  selector: 'app-show-list-entry',
  templateUrl: './show-list-entry.component.html',
  styleUrls: ['./show-list-entry.component.css']
})
export class ShowListEntryComponent implements OnInit {
  title: string = '';

  @Input()
  property!: ScrapingProperty;

  showSpinner: boolean = true;

  constructor(private commonService: CommonService, private showService: ShowService) {
  }

  onTitleClick() {
    this.commonService.onSeriesTitleClicked(this.property.name);
  }

  onNotificationClick() {
    this.property.notification = !this.property.notification;
    this.commonService.onNotificationClick(this.property);
  }

  onDeleteClick() {
    this.commonService.onDeleteEntryClick(this.property.name);
  }

  ngOnInit(): void {
    this.showService.getTitle(this.property.name).subscribe({
      next: (response) => {
        this.title = response;
        this.showSpinner = false;
      },
      error: (error) => console.log(error)
    })
  }
}
