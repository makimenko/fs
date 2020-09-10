import {Injectable} from '@angular/core';
import {Book} from '../model/book';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BooksApiService {

  private baseUrl = environment.bffUrl + '/book';
  private findUrl = this.baseUrl + '/find';

  constructor(private http: HttpClient) {
  }

  public getBooks(templateBook: Book): Observable<Book[]> {

    console.log('POST:', templateBook);
    return this.http.post<Book[]>(this.findUrl, templateBook);
  }

}
