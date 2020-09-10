import {Component, OnInit} from '@angular/core';
import {BooksApiService} from '../services/books-api.service';
import {Book} from '../model/book';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  books: Book[];

  gridColumns = 4;

  constructor(private booksApi: BooksApiService) {
  }

  ngOnInit(): void {

    this.search();
  }

  search(templateBook?: Book) {
    console.log('Search');
    console.log(templateBook);
    this.booksApi.getBooks(templateBook).subscribe(data => this.books = data);
  }

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 3 ? 4 : 3;
  }

}
