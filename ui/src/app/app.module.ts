import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HomeComponent} from './home/home.component';
import {MatButtonModule} from "@angular/material/button";
import {ComicComponent} from './comic-renderer/comic/comic.component';
import {HttpClientModule} from '@angular/common/http';
import {ChapterComponent} from './comic-renderer/comic/chapter/chapter.component';
import {PageComponent} from './comic-renderer/comic/page/page.component';
import {MatMenuModule} from "@angular/material/menu";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {ComicsListComponent} from './comics-list/comics-list.component';
import {MatListModule} from "@angular/material/list";
import {ComicsListEntryComponent} from './comics-list/comics-list-entry/comics-list-entry.component';
import {ComicRendererComponent} from './comic-renderer/comic-renderer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ComicComponent,
    ChapterComponent,
    PageComponent,
    ComicsListComponent,
    ComicsListEntryComponent,
    ComicRendererComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatMenuModule,
    MatPaginatorModule,
    MatInputModule,
    MatSelectModule,
    MatProgressBarModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
