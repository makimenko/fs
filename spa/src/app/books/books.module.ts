import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {BookListComponent} from './book-list/book-list.component';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatGridListModule} from "@angular/material/grid-list";
import { BookListItemComponent } from './book-list/book-list-item/book-list-item.component';
import {MatCardModule} from "@angular/material/card";

@NgModule({
  declarations: [
    BookListComponent,
    BookListItemComponent
  ],
  exports: [
    BookListComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    MatGridListModule,
    MatCardModule
  ]
})
export class BooksModule {
}
