import {Injectable} from '@angular/core';
import {Book} from '../model/book';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BooksApiService {

  private url = environment.bffUrl + '/books';

  constructor(private http: HttpClient) {
  }

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.url);
  }

}
