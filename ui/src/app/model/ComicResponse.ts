export interface ComicResponse {
  comic: Comic;
}

export interface Comic {
  title: string;
  chapters?: (Chapter)[];
}

export interface Chapter {
  title: string;
  pages?: (Page)[];
}

export interface Page {
  url: string;
}
