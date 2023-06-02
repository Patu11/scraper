import {Component, OnInit} from '@angular/core';
import {CommonService} from "../service/common.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentType: string = 'series';

  constructor(private commonService: CommonService) {
  }

  ngOnInit(): void {
    this.commonService.clickedMenuEntry.subscribe((data) => this.currentType = data);
  }
}
