import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Book} from "../model/book";
import {FormControl, FormGroup} from "@angular/forms";
import {BooksApiService} from "../services/books-api.service";

@Component({
  selector: 'app-book-toolbar',
  templateUrl: './book-toolbar.component.html',
  styleUrls: ['./book-toolbar.component.scss']
})
export class BookToolbarComponent implements OnInit {

  searchForm = new FormGroup({
    title: new FormControl('')
  });

  @Output()
  onFilterChange: EventEmitter<Book> = new EventEmitter<Book>();

  constructor(private bookApiService: BooksApiService) {
  }

  ngOnInit(): void {
  }


  onSubmit() {
    console.log(this.searchForm.value);
    this.onFilterChange.emit(this.searchForm.value)
  }

}
