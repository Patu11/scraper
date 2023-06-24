import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ShowRendererComponent} from './show-renderer.component';

describe('SeriesRendererComponent', () => {
  let component: ShowRendererComponent;
  let fixture: ComponentFixture<ShowRendererComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowRendererComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
