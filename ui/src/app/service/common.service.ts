import {EventEmitter, Injectable, Output} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  @Output()
  clickedTitle = new EventEmitter<string>();

  constructor() {
  }

  onTitleClicked(rawTitle: string) {
    this.clickedTitle.emit(rawTitle);
  }
}
