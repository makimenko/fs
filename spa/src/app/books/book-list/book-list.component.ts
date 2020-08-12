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

  constructor(private booksApi: BooksApiService) {
  }

  ngOnInit(): void {
    this.reload();
  }

  public reload(): void {
    this.booksApi.getBooks().subscribe(data => this.books = data);
  }


}
