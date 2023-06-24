import {Component, OnInit} from '@angular/core';
import {ScrapingPropertiesService} from "../../service/scraping-properties.service";
import {ScrapingProperty} from "../../model/ScrapingProperty";
import {CommonService} from "../../service/common.service";

@Component({
  selector: 'app-series-list',
  templateUrl: './series-list.component.html',
  styleUrls: ['./series-list.component.css']
})
export class SeriesListComponent implements OnInit {
  urlTitles: ScrapingProperty[] = [];
  showError: boolean = false;
  loading: boolean = false;

  constructor(private scrapingPropertiesService: ScrapingPropertiesService, private commonService: CommonService) {
  }

  ngOnInit(): void {
    this.loading = true;
    this.scrapingPropertiesService.getPropertiesByType("series").subscribe({
      next: (response) => {
        this.urlTitles = response;
        this.showError = false;
        this.loading = false;
      },
      error: () => {
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
  }
}
