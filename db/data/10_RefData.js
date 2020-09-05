db = db.getSiblingDB("db");

// bookGenre
db.bookGenre.drop();
db.bookGenre.insert({_id:"FAN", name:"Fantasy"});
db.bookGenre.insert({_id:"ADV", name:"Adventure"});
db.bookGenre.insert({_id:"ROM", name:"Romance"});
db.bookGenre.insert({_id:"CON", name:"Contemporary"});
db.bookGenre.insert({_id:"DYS", name:"Dystopian"});
db.bookGenre.insert({_id:"MYS", name:"Mystery"});
db.bookGenre.insert({_id:"HOR", name:"Horror"});
db.bookGenre.insert({_id:"TH", name:"Thriller"});
db.bookGenre.insert({_id:"PAR", name:"Paranormal"});
db.bookGenre.insert({_id:"HIS", name:"Historical fiction"});
db.bookGenre.insert({_id:"SCI", name:"Science Fiction"});
db.bookGenre.insert({_id:"MEM", name:"Memoir"});
db.bookGenre.insert({_id:"COO", name:"Cooking"});
db.bookGenre.insert({_id:"ART", name:"Art"});
db.bookGenre.insert({_id:"SH", name:"Self-help / Personal"});
db.bookGenre.insert({_id:"DEV", name:"Development"});
