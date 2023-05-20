import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Episode, SeriesResponse} from "../model/SeriesResponse";

@Injectable({
  providedIn: 'root'
})
export class SeriesService {
  private URL: string = 'http://localhost:8080/api/v1/series/';

  constructor(private http: HttpClient) {
  }

  getSeries(seriesUrl: string) {
    return this.http.get<SeriesResponse>(this.URL + seriesUrl);
  }

  getAllTitles() {
    return this.http.get<string[]>(this.URL + "titles");
  }

  getNextEpisode(seriesUrl: string) {
    return this.http.get<Episode>(this.URL + seriesUrl + "/episodes/next");
  }
}
