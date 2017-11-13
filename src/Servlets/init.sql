DROP TABLE IF EXISTS Paper, Author, Writes, PCMember, Review;

CREATE TABLE Paper	(
	PaperID 	INTEGER,
	Title 		VARCHAR(50),
	Abstract 	VARCHAR(250),
	Pdf 		VARCHAR(100),
	PRIMARY KEY (PaperID)
);

CREATE TABLE Author	(
	Email 		VARCHAR(100),
	AuthorName 	VARCHAR(50),
	Affiliation VARCHAR(100),
	PRIMARY KEY (email)
);

CREATE TABLE Writes(
	PaperID 	INTEGER,
	Email 		VARCHAR(50),
	AuthorOrder INTEGER,
	PRIMARY KEY (PaperID, Email),
	FOREIGN KEY (PaperID) REFERENCES Paper(PaperID),
	FOREIGN KEY (Email) REFERENCES Author(Email)
);

CREATE TABLE PCMember(
	Email 		VARCHAR(50),
	MemberName 	VARCHAR(20),
	PRIMARY KEY (email)		
);

CREATE TABLE Review(
	ReportID 	INTEGER,
	SubDate 	DATE,
	Comment		VARCHAR(250),
	Recommend	CHAR(1),
	PaperID 	INTEGER,
	Email 		VARCHAR(100),
	FOREIGN KEY (PaperID) REFERENCES Paper(PaperID),
	FOREIGN KEY (Email) REFERENCES PCMember(Email),
	UNIQUE (PaperID, Email)
);