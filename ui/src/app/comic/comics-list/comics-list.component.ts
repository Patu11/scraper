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
  showError: boolean = false;
  loading: boolean = false;

  constructor(private comicsService: ComicsService) {
  }

  ngOnInit(): void {
    this.loading = true;
    this.comicsService.getAllTitles().subscribe(
      (response) => {
        this.titles = response;
        this.showError = false;
        this.loading = false;
      },
      () => {
        this.showError = true;
        this.loading = false;
      }
    )
  }
}
