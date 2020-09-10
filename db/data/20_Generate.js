db = db.getSiblingDB("db");


function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function getDatePlus(addDays) {
    return new Date(new Date().setDate(new Date().getDate() + addDays));
}

function getDateString(date) {
    return date.toISOString().substring(0, 10);
}

function capFirst(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function generatePersonName(){
	var name1 = ["nick", "john", "amanda", "mihail", "alex", "pamela", "Olivia", "emma", "olga", "tatyana", "elena", "alise", "george"];
	var name2 = ["Smith", "Johnson", "Williams", "Brown", "Miller", "Davis", "Kingsley", "Miller", "Parker", "West", "East", "Nash", "Nixon", "Brady", "Finley"];
	var name = capFirst(name1[getRandomInt(0, name1.length - 1)]) + ' ' + capFirst(name2[getRandomInt(0, name2.length - 1)]);
	return name;
}

function generateBookName(){
    var name1 = ["very", "greatest", "", "", ""];
	var name2 = ["happy", "sad", "useless", "mad", "crying", "flying", "running", "swimming"];
    var name3 = ["dog", "cat", "woman", "man", "car", "train", "ship", "bird", "house", "home", "flat", "apartments", "book", "sofa", "lamp", "box"];
    var name4 = ["memories", "opportunities", "2", "", "", "", "", "", "", "", "", "", "", ""];
    var name =  capFirst(name1[getRandomInt(0, name1.length - 1)]) 
        + ' ' + capFirst(name2[getRandomInt(0, name2.length - 1)]) 
        + ' ' + capFirst(name3[getRandomInt(0, name3.length - 1)])
        + ' ' + capFirst(name4[getRandomInt(0, name4.length - 1)]);
	return name.trim();
}


function getRandomReferences(collection, min, max) {   
    return collection.aggregate([{ $sample: { size: getRandomInt(min,max) } }])._batch.map(a=>a._id);
}



//----------------------------------------------------------------------
db.author.drop();
for (var i = 1; i <= 20; i++) {    
  db.author.insert( 
    { 
      name : generatePersonName(),
      birthDate: getDateString(getDatePlus(-getRandomInt(365*30,365*80))),
      licenseId: 'LIC-'+getRandomInt(321321,5446541122)
    } 
  ) 
}

//----------------------------------------------------------------------
db.book.drop();
for (var i = 1; i <= 100; i++) {    
  db.book.insert( 
    { 
      isbn: getRandomInt(1231434232,9231434232),
      title : generateBookName(),
      releaseDate: getDatePlus(-getRandomInt(10,300)) ,
      avgRank: getRandomInt(5,10),
      bookGenres: getRandomReferences(db.bookGenre, 1, 3),
      authors: getRandomReferences(db.author, 1, 2)
    } 
  ) 
}

//----------------------------------------------------------------------