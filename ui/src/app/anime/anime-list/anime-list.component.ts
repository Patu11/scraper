import {Component} from '@angular/core';
import {AnimeService} from "../../service/anime.service";
import {UrlTitle} from "../../model/UrlTitle";

@Component({
  selector: 'app-anime-list',
  templateUrl: './anime-list.component.html',
  styleUrls: ['./anime-list.component.css']
})
export class AnimeListComponent {
  urlTitles: UrlTitle[] = [];
  showError: boolean = false;
  loading: boolean = false;

  constructor(private animeService: AnimeService) {
  }

  ngOnInit(): void {
    this.loading = true;
    this.animeService.getAllTitles().subscribe({
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
