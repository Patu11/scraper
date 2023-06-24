import {Component, Input, OnInit} from '@angular/core';
import {Episode, Show} from "../../../model/Show";

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  @Input()
  show?: Show;

  @Input()
  nextEpisode?: Episode;

  constructor() {
  }

  ngOnInit(): void {
  }

}
