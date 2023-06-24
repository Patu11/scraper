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
import {ShowListComponent} from './show/show-list/show-list.component';
import {ShowListEntryComponent} from './show/show-list/show-list-entry/show-list-entry.component';
import {ShowRendererComponent} from './show/show-renderer/show-renderer.component';
import {ShowComponent} from './show/show-renderer/show/show.component';

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
import {PropertyComponent} from './property/property.component';
import {FormsModule} from "@angular/forms";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";

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
    ShowListComponent,
    ShowListEntryComponent,
    ShowRendererComponent,
    ShowComponent,
    ToolbarComponent,
    ErrorComponent,
    PropertyComponent
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
    MatSidenavModule,
    FormsModule,
    MatButtonToggleModule,
    MatProgressSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
