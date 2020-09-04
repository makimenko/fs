db = db.getSiblingDB("db");

// BookGenre
db.bookgenre.drop();
db.bookgenre.insert({id:"C", name:"Comedy"});
db.bookgenre.insert({id:"D", name:"Drama"});
