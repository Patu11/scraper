import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimeRendererComponent } from './anime-renderer.component';

describe('AnimeRendererComponent', () => {
  let component: AnimeRendererComponent;
  let fixture: ComponentFixture<AnimeRendererComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnimeRendererComponent]
    });
    fixture = TestBed.createComponent(AnimeRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
