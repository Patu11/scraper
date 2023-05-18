import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComicsListEntryComponent } from './comics-list-entry.component';

describe('ComicsListEntryComponent', () => {
  let component: ComicsListEntryComponent;
  let fixture: ComponentFixture<ComicsListEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComicsListEntryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComicsListEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
