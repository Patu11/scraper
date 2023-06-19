import {Component, Input} from '@angular/core';
import {Episode} from "../../../../model/SeriesResponse";
import {Anime} from "../../../../model/Anime";

@Component({
  selector: 'app-anime',
  templateUrl: './anime.component.html',
  styleUrls: ['./anime.component.css']
})
export class AnimeComponent {
  @Input()
  anime?: Anime;

  @Input()
  nextEpisode?: Episode;
}
