import {Component, OnInit} from '@angular/core';
import {ScrapingPropertiesService} from "../../service/scraping-properties.service";
import {ScrapingProperty} from "../../model/ScrapingProperty";
import {CommonService} from "../../service/common.service";

@Component({
  selector: 'app-show-list',
  templateUrl: './show-list.component.html',
  styleUrls: ['./show-list.component.css']
})
export class ShowListComponent implements OnInit {
  urlTitles: ScrapingProperty[] = [];
  showError: boolean = false;
  loading: boolean = false;

  constructor(private scrapingPropertiesService: ScrapingPropertiesService, private commonService: CommonService) {
  }

  ngOnInit(): void {
    this.loading = true;
    this.scrapingPropertiesService.getPropertiesByType("show").subscribe({
      next: (response) => {
        this.urlTitles = response;
        this.showError = false;
        this.loading = false;
      },
      error: (error) => {
        console.log(error);
        this.showError = true;
        this.loading = false;
      }
    });

    this.commonService.clickedDeleteEntry.subscribe((data) => {
      this.scrapingPropertiesService.deletePropertyByName(data).subscribe({
        next: (response) => console.log(response),
        error: (error) => console.log(error)
      });
      this.urlTitles = this.urlTitles.filter(entry => entry.name !== data);
    });

    this.commonService.clickedNotificationEntry.subscribe((data) => {
      this.scrapingPropertiesService.updateProperty(data).subscribe({
        next: (response) => console.log(response),
        error: (error) => console.log(error)
      });
    });
  }
}
