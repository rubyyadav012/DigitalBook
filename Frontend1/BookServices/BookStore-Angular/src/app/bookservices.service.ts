import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const url=" https://711tzm0no5.execute-api.us-west-2.amazonaws.com/api/digitalbooks/author/1/books"
const allbook="https://711tzm0no5.execute-api.us-west-2.amazonaws.com/api/digitalbooks/books/search/allBook"
const signupUrl="https://711tzm0no5.execute-api.us-west-2.amazonaws.com/api/api/auth/signup"
const login=   "https://711tzm0no5.execute-api.us-west-2.amazonaws.com/api/api/auth/login"
const paymentUrl="http://localhost:9093/bill/payment"

@Injectable({
  providedIn: 'root'
})
export class BookservicesService {

  public addBook(book:any){
    return this.http.post(url,book);
  }

  public getBook(){
    return this.http.get(allbook);
  }

  public signUp(author:any){
    return this.http.post(signupUrl,author)
  }

  public login(author:any){
    return this.http.post(login,author)
  }

  public payment(bill:any){
    return this.http.post(paymentUrl,bill)
  }

  constructor(private http:HttpClient) {
    
  }
}
