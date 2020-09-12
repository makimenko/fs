import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-genre-filter',
  templateUrl: './book-genre-filter.component.html',
  styleUrls: ['./book-genre-filter.component.scss']
})
export class BookGenreFilterComponent implements OnInit {

  bookGenres: string[] = ['Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];

  constructor() { }

  ngOnInit(): void {
  }

}
