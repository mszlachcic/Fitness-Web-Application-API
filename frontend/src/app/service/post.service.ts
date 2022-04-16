import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Store } from '@ngrx/store';
import { addPost } from '../state/post.actions';

export interface IUserDto{
  username: string
}

export interface IPostDto{
  description:string,
  postDate: Date,
  routeDate: Date,
  userDto: IUserDto
}

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient, private store: Store) { 
    this.addAllPostsToStore();
  }

  posts:IPostDto[] = [];
  url = 'http://127.0.0.1:8080/posts/';

  addAllPostsToStore() {
    this.fetchPost().subscribe(
      (res) => {
        for (let i = 0; i < res.length; i++) {
          let post = res[i];
          this.store.dispatch(addPost({post}));
          this.posts.push(res[i]);
        }
      }
    )
  }

  fetchPost(){
    console.log("fetchowanie postów");
    return this.http.get<IPostDto[]>(`${this.url}getAllPosts`)
  }
}
