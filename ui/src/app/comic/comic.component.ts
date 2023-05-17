import {Component, OnInit} from '@angular/core';
import {ComicsService} from "../service/comics.service";
import {Chapter} from "../model/ComicResponse";

@Component({
  selector: 'app-comic',
  templateUrl: './comic.component.html',
  styleUrls: ['./comic.component.css']
})
export class ComicComponent implements OnInit {
  title: string = '';
  chapters?: Chapter[];
  selectedChapter?: Chapter;
  allTitles: string[] = [];
  allUrls: string[] = [];
  loading: boolean = false;
  show: boolean = false;

  constructor(private comicsService: ComicsService) {
  }

  onChapterClick(chapter: Chapter) {
    this.selectedChapter = chapter;
  }

  handleTitleClick(title: string) {
    this.loading = true;
    this.show = false;
    this.title = '';
    this.chapters = [];
    this.selectedChapter = undefined;
    this.comicsService.getComic(title).subscribe(
      (response) => {
        this.title = response.comic.title;
        this.chapters = response.comic.chapters;
        this.loading = false;
        this.show = true;
      });
  }

  mapResponse(response: string[]) {
    this.allUrls = response.map(input => input.split(":")[0]);
    this.allTitles = response.map(input => input.split(":")[1]);
  }

  ngOnInit(): void {
    this.comicsService.getAllTitles().subscribe(
      (response) => this.mapResponse(response as string[])
    )

    // this.comicsService.getComic('TWD').subscribe(
    //   (response) => {
    //     this.title = response.comic.title;
    //     this.chapters = response.comic.chapters;
    //     this.loading = false;
    //   });
  }

}
