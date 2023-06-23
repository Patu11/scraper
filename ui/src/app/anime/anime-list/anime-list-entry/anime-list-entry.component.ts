import {Component, Input} from '@angular/core';
import {CommonService} from "../../../service/common.service";
import {AnimeService} from "../../../service/anime.service";

@Component({
  selector: 'app-anime-list-entry',
  templateUrl: './anime-list-entry.component.html',
  styleUrls: ['./anime-list-entry.component.css']
})
export class AnimeListEntryComponent {
  title: string = '';

  @Input()
  rawTitle: string = '';

  constructor(private commonService: CommonService, private animeService: AnimeService) {
  }

  onTitleClick() {
    this.commonService.onAnimeTitleClicked(this.rawTitle);
  }

  ngOnInit(): void {
    this.animeService.getTitle(this.rawTitle).subscribe({
      next: (response) => this.title = response,
      error: (error) => console.log(error)
    })
  }
}
