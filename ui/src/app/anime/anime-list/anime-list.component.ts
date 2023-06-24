import {Component} from '@angular/core';
import {ScrapingProperty} from "../../model/ScrapingProperty";
import {ScrapingPropertiesService} from "../../service/scraping-properties.service";

@Component({
  selector: 'app-anime-list',
  templateUrl: './anime-list.component.html',
  styleUrls: ['./anime-list.component.css']
})
export class AnimeListComponent {
  urlTitles: ScrapingProperty[] = [];
  showError: boolean = false;
  loading: boolean = false;

  constructor(private scrapingPropertiesService: ScrapingPropertiesService) {
  }

  ngOnInit(): void {
    this.loading = true;
    this.scrapingPropertiesService.getPropertiesByType("anime").subscribe({
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
