import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookGenreFilterComponent } from './book-genre-filter.component';

describe('BookGenreFilterComponent', () => {
  let component: BookGenreFilterComponent;
  let fixture: ComponentFixture<BookGenreFilterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookGenreFilterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookGenreFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
