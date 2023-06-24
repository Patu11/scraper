import {Component} from '@angular/core';
import {ScrapingPropertiesService} from "../service/scraping-properties.service";
import {ScrapingProperty} from "../model/ScrapingProperty";

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrls: ['./property.component.css']
})
export class PropertyComponent {
  type: string = '';
  name: string = '';

  constructor(private scrapingPropertiesService: ScrapingPropertiesService) {
  }

  onAddButtonClick() {
    const property: ScrapingProperty = {
      name: this.name,
      type: this.type
    };
    
    this.scrapingPropertiesService.addProperty(property).subscribe({
      next: (response) => console.log(response),
      error: (error) => console.log(error)
    });
  }

  onValueChange(type: string) {
    this.type = type;
  }

  shouldBeDisabled() {
    return this.name === '' || this.type === '';
  }

}
