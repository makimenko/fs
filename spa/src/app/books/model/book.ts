import ObjectID from "bson-objectid";

export interface BookGenre {
  id: string;
  name: string;
}

export interface Book {
  id: ObjectID;
  title: string;
  bookGenres: BookGenre[]
}
