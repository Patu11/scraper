import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Episode} from "../model/SeriesResponse";
import {Anime} from "../model/Anime";

@Injectable({
  providedIn: 'root'
})
export class AnimeService {
  private URL: string = environment.apiUrl + 'anime/';

  constructor(private http: HttpClient) {
  }

  getAnime(animeId: string) {
    return this.http.get<Anime>(this.URL + animeId);
  }

  getTitle(animeId: string) {
    return this.http.get(this.URL + "title/" + animeId, {responseType: "text"});
  }

  getNextEpisode(animeId: string) {
    return this.http.get<Episode>(this.URL + animeId + "/episodes/next");
  }
}
