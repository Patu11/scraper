import {EventEmitter, Injectable, Output} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  @Output()
  clickedComicTitle: EventEmitter<string> = new EventEmitter<string>();

  @Output()
  clickedSeriesTitle: EventEmitter<string> = new EventEmitter<string>();

  @Output()
  clickedAnimeTitle: EventEmitter<string> = new EventEmitter<string>();

  @Output()
  clickedMenuEntry: EventEmitter<string> = new EventEmitter<string>();

  @Output()
  clickedDeleteEntry: EventEmitter<string> = new EventEmitter<string>();

  constructor() {
  }

  onComicTitleClicked(rawTitle: string) {
    this.clickedComicTitle.emit(rawTitle);
  }

  onSeriesTitleClicked(rawTitle: string) {
    this.clickedSeriesTitle.emit(rawTitle);
  }

  onAnimeTitleClicked(rawTitle: string) {
    this.clickedAnimeTitle.emit(rawTitle);
  }

  onMenuClick(entry: string) {
    this.clickedMenuEntry.emit(entry);
  }

  onDeleteEntryClick(entry: string) {
    this.clickedDeleteEntry.emit(entry);
  }
}
