import {Component, OnInit} from '@angular/core';
import {ComicsService} from "../../service/comics.service";
import {UrlTitle} from "../../model/UrlTitle";

@Component({
  selector: 'app-comics-list',
  templateUrl: './comics-list.component.html',
  styleUrls: ['./comics-list.component.css']
})
export class ComicsListComponent implements OnInit {
  titles: UrlTitle[] = [];

  constructor(private comicsService: ComicsService) {
  }

  ngOnInit(): void {
    this.comicsService.getAllTitles().subscribe(
      (response) => this.titles = response
    )
  }
}
