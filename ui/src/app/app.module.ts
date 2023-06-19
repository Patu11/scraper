import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HomeComponent} from './home/home.component';

import {ComicComponent} from './comic/comic-renderer/comic/comic.component';
import {HttpClientModule} from '@angular/common/http';
import {ChapterComponent} from './comic/comic-renderer/comic/chapter/chapter.component';
import {PageComponent} from './comic/comic-renderer/comic/page/page.component';


import {ComicsListComponent} from './comic/comics-list/comics-list.component';

import {ComicsListEntryComponent} from './comic/comics-list/comics-list-entry/comics-list-entry.component';
import {ComicRendererComponent} from './comic/comic-renderer/comic-renderer.component';
import {SeriesListComponent} from './series/series-list/series-list.component';
import {SeriesListEntryComponent} from './series/series-list/series-list-entry/series-list-entry.component';
import {SeriesRendererComponent} from './series/series-renderer/series-renderer.component';
import {SeriesComponent} from './series/series-renderer/series/series.component';

import {ToolbarComponent} from './toolbar/toolbar.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {ErrorComponent} from './error/error/error.component';
import {MatButtonModule} from "@angular/material/button";
import {MatMenuModule} from "@angular/material/menu";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {AnimeListComponent} from './anime/anime-list/anime-list.component';
import {AnimeListEntryComponent} from './anime/anime-list/anime-list-entry/anime-list-entry.component';
import {AnimeRendererComponent} from './anime/anime-renderer/anime-renderer.component';
import {AnimeComponent} from './anime/anime-renderer/anime/anime/anime.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ComicComponent,
    ChapterComponent,
    PageComponent,
    ComicsListComponent,
    ComicsListEntryComponent,
    ComicRendererComponent,
    SeriesListComponent,
    SeriesListEntryComponent,
    SeriesRendererComponent,
    SeriesComponent,
    ToolbarComponent,
    ErrorComponent,
    AnimeListComponent,
    AnimeListEntryComponent,
    AnimeRendererComponent,
    AnimeComponent
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
    MatListModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
