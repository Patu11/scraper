import {Component, OnInit} from '@angular/core';
import {ComicsService} from "../service/comics.service";

@Component({
  selector: 'app-comics-list',
  templateUrl: './comics-list.component.html',
  styleUrls: ['./comics-list.component.css']
})
export class ComicsListComponent implements OnInit {
  titlesMap: Map<string, string> = new Map();

  constructor(private comicsService: ComicsService) {
  }

  mapTitlesResponse(titlesResponse: string[]) {
    titlesResponse.forEach(input => {
      let split = input.split(":")
      let key = split[0]
      let value = split[1]
      this.titlesMap.set(key, value);
    });
  }

  ngOnInit(): void {
    this.comicsService.getAllTitles().subscribe(
      (response) => this.mapTitlesResponse(response as string[])
    )
  }
}
