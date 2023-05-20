import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComicRendererComponent } from './comic-renderer.component';

describe('ComicRendererComponent', () => {
  let component: ComicRendererComponent;
  let fixture: ComponentFixture<ComicRendererComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComicRendererComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComicRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
