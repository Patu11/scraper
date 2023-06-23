import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Episode, SeriesResponse} from "../model/SeriesResponse";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SeriesService {
  private URL: string = environment.apiUrl + 'series/';

  constructor(private http: HttpClient) {
  }

  getSeries(seriesUrl: string) {
    return this.http.get<SeriesResponse>(this.URL + seriesUrl);
  }

  getTitle(seriesUrl: string) {
    return this.http.get(this.URL + "title/" + seriesUrl, {responseType: "text"});
  }
  
  getNextEpisode(seriesUrl: string) {
    return this.http.get<Episode>(this.URL + seriesUrl + "/episodes/next");
  }
}
