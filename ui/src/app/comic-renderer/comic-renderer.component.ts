import {Component, OnInit} from '@angular/core';
import {CommonService} from "../service/common.service";
import {ComicsService} from "../service/comics.service";
import {Comic, ComicResponse} from "../model/ComicResponse";

@Component({
  selector: 'app-comic-renderer',
  templateUrl: './comic-renderer.component.html',
  styleUrls: ['./comic-renderer.component.css']
})
export class ComicRendererComponent implements OnInit {
  comic?: Comic;
  loading: boolean = false;

  constructor(private commonService: CommonService, private comicsService: ComicsService) {
  }

  getComicResponse(rawTitle: string) {
    this.loading = true;
    this.comicsService.getComic(rawTitle).subscribe((response) => {
      const comicResponse = response as ComicResponse;
      this.comic = comicResponse.comic;
      this.loading = false;
    });
  }

  ngOnInit(): void {
    this.commonService.clickedTitle.subscribe((data) => this.getComicResponse(data))
  }

}
