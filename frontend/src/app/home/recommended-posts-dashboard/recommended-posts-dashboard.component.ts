import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { IPostDto, PostService } from 'src/app/service/post.service';
import { AppState, selectPosts } from 'src/app/state/post.selector';

@Component({
  selector: 'app-recommended-posts-dashboard',
  templateUrl: './recommended-posts-dashboard.component.html',
  styleUrls: ['./recommended-posts-dashboard.component.scss']
})
export class RecommendedPostsDashboardComponent implements OnInit {

  posts:Observable<IPostDto[]>;

  constructor(private postService:PostService,private store: Store<AppState>) { 
    this.posts = this.store.select(selectPosts);
    console.log(this.posts);
  }

  ngOnInit(): void {
  }

}
