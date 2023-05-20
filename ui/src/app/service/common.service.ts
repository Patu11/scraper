import {EventEmitter, Injectable, Output} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  @Output()
  clickedComicTitle = new EventEmitter<string>();

  @Output()
  clickedSeriesTitle: EventEmitter<string> = new EventEmitter<string>();

  constructor() {
  }

  onComicTitleClicked(rawTitle: string) {
    this.clickedComicTitle.emit(rawTitle);
  }

  onSeriesTitleClicked(rawTitle: string) {
    this.clickedSeriesTitle.emit(rawTitle);
  }
}
