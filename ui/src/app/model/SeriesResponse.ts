export interface SeriesResponse {
  series: Series;
}

export interface Series {
  title: string;
  coverUrl: string;
  seasons?: (Season)[]
}

export interface Season {
  number: number;
  episodes?: (Episode)[];
}

export interface Episode {
  title: string;
  premiere: string;
}
