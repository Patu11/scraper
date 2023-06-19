import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimeListEntryComponent } from './anime-list-entry.component';

describe('AnimeListEntryComponent', () => {
  let component: AnimeListEntryComponent;
  let fixture: ComponentFixture<AnimeListEntryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnimeListEntryComponent]
    });
    fixture = TestBed.createComponent(AnimeListEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
