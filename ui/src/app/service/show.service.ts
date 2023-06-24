import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Episode, Show} from "../model/Show";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ShowService {
  private URL: string = environment.apiUrl + 'show/';

  constructor(private http: HttpClient) {
  }

  getSeries(showId: string) {
    return this.http.get<Show>(this.URL + showId);
  }

  getTitle(showId: string) {
    return this.http.get(this.URL + "title/" + showId, {responseType: "text"});
  }

  getNextEpisode(showId: string) {
    return this.http.get<Episode>(this.URL + showId + "/episodes/next");
  }
}
