import {Component} from '@angular/core';
import {CommonService} from "../../service/common.service";
import {AnimeService} from "../../service/anime.service";
import {Episode} from "../../model/SeriesResponse";
import {Anime} from "../../model/Anime";

@Component({
  selector: 'app-anime-renderer',
  templateUrl: './anime-renderer.component.html',
  styleUrls: ['./anime-renderer.component.css']
})
export class AnimeRendererComponent {
  anime?: Anime;
  nextEpisode?: Episode;
  loading: boolean = false;

  constructor(private commonService: CommonService, private animeService: AnimeService) {
  }

  getAnimeResponse(rawTitle: string) {
    this.loading = true;
    this.animeService.getAnime(rawTitle).subscribe((response) => {
      this.anime = response as Anime;
      this.loading = false;
    });

    this.animeService.getNextEpisode(rawTitle).subscribe({
      next: (response) => this.nextEpisode = response as Episode,
      error: () => {
        this.nextEpisode = {
          title: 'Unknown',
          premiere: 'Unknown'
        }
      }
    })
    
  }

  ngOnInit(): void {
    this.commonService.clickedAnimeTitle.subscribe((data) => this.getAnimeResponse(data))
  }

}
