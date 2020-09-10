import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {BookListComponent} from './book-list/book-list.component';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatGridListModule} from "@angular/material/grid-list";
import {BookListItemComponent} from './book-list/book-list-item/book-list-item.component';
import {MatCardModule} from "@angular/material/card";
import {BookHomeComponent} from './book-home/book-home.component';
import {BookToolbarComponent} from './book-toolbar/book-toolbar.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldControl, MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import { FlexLayoutModule } from "@angular/flex-layout";
import {MatChipsModule} from "@angular/material/chips";

@NgModule({
  declarations: [
    BookListComponent,
    BookListItemComponent,
    BookHomeComponent,
    BookToolbarComponent
  ],
  exports: [
    BookListComponent,
    BookHomeComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    MatGridListModule,
    MatCardModule,
    MatToolbarModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatChipsModule
  ]
})
export class BooksModule {
}
