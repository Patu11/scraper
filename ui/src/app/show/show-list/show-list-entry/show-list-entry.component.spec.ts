import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ShowListEntryComponent} from './show-list-entry.component';

describe('SeriesListEntryComponent', () => {
  let component: ShowListEntryComponent;
  let fixture: ComponentFixture<ShowListEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowListEntryComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowListEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
