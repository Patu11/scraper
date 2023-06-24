import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {ScrapingProperty} from "../model/ScrapingProperty";

@Injectable({
  providedIn: 'root'
})
export class ScrapingPropertiesService {
  private URL: string = environment.apiUrl + 'property/';

  constructor(private http: HttpClient) {
  }

  getPropertiesByType(type: string) {
    return this.http.get<ScrapingProperty[]>(this.URL + type);
  }

  deletePropertyByName(name: string) {
    return this.http.delete(this.URL + "delete/" + name);
  }

  addProperty(property: ScrapingProperty) {
    return this.http.post(this.URL + "add", property);
  }
}
