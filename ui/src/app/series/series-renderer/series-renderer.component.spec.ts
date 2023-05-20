import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriesRendererComponent } from './series-renderer.component';

describe('SeriesRendererComponent', () => {
  let component: SeriesRendererComponent;
  let fixture: ComponentFixture<SeriesRendererComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeriesRendererComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeriesRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
