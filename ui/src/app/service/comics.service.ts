import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ComicResponse} from "../model/ComicResponse";

@Injectable({
  providedIn: 'root'
})
export class ComicsService {
  private URL: string = 'http://localhost:8080/api/v1/comic/';

  constructor(private http: HttpClient) {
  }

  getComic(comicType: string) {
    return this.http.get<ComicResponse>(this.URL + comicType);
  }
}
