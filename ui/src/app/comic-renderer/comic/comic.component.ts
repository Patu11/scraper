import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Chapter, Comic} from "../../model/ComicResponse";

@Component({
  selector: 'app-comic',
  templateUrl: './comic.component.html',
  styleUrls: ['./comic.component.css']
})
export class ComicComponent implements OnInit, OnChanges {
  @Input()
  comic?: Comic;

  selectedChapter?: Chapter;

  constructor() {
  }

  onChapterClick(chapter: Chapter) {
    this.selectedChapter = chapter;
  }

  ngOnChanges(): void {
    this.selectedChapter = undefined;
  }

  ngOnInit(): void {
  }
}
