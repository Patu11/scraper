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

  constructor(private comicsService: ComicsService) {
  }

  onChapterClick(chapter: Chapter) {
    this.selectedChapter = chapter;
  }

  ngOnInit(): void {
    this.comicsService.getComic('TWD').subscribe(
      (response) => {
        this.title = response.comic.title;
        this.chapters = response.comic.chapters;
      });
  }

}
