import {Component, OnInit} from '@angular/core';
import {ScrapingPropertiesService} from "../../service/scraping-properties.service";
import {ScrapingProperty} from "../../model/ScrapingProperty";

@Component({
  selector: 'app-series-list',
  templateUrl: './series-list.component.html',
  styleUrls: ['./series-list.component.css']
})
export class SeriesListComponent implements OnInit {
  urlTitles: ScrapingProperty[] = [];
  showError: boolean = false;
  loading: boolean = false;

  constructor(private scrapingPropertiesService: ScrapingPropertiesService) {
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
  }
}
