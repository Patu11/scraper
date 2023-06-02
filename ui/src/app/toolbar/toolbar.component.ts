import {Component, OnInit} from '@angular/core';
import {CommonService} from "../service/common.service";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(private commonService: CommonService) {
  }

  onMenuChange(event: string) {
    this.commonService.onMenuClick(event);
  }

  ngOnInit(): void {
  }

}
