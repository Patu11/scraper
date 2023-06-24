import { TestBed } from '@angular/core/testing';

import { ScrapingPropertiesService } from './scraping-properties.service';

describe('ScrapingPropertiesService', () => {
  let service: ScrapingPropertiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScrapingPropertiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
