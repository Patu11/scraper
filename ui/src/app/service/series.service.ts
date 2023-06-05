import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Episode, SeriesResponse} from "../model/SeriesResponse";
import {UrlTitle} from "../model/UrlTitle";
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

  getAllTitles() {
    return this.http.get<UrlTitle[]>(this.URL + "titles");
  }

  getNextEpisode(seriesUrl: string) {
    return this.http.get<Episode>(this.URL + seriesUrl + "/episodes/next");
  }
}
