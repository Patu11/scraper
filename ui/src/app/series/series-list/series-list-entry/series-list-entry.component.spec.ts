import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriesListEntryComponent } from './series-list-entry.component';

describe('SeriesListEntryComponent', () => {
  let component: SeriesListEntryComponent;
  let fixture: ComponentFixture<SeriesListEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeriesListEntryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeriesListEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
