-- Table Acteur
CREATE TABLE Acteur (
    idImdb VARCHAR(50) PRIMARY KEY,
    identite VARCHAR(255),
    href VARCHAR(255),
    anniversaire DATE
);

-- Table Role (chaque acteur peut avoir plusieurs rôles, chaque rôle est dans un film)
CREATE TABLE Role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    acteur_id VARCHAR(50),
    film_id VARCHAR(50),
    FOREIGN KEY (acteur_id) REFERENCES Acteur(idImdb),
    FOREIGN KEY (film_id) REFERENCES Film(idImdb)
);

-- Table Film
CREATE TABLE Film (
    idImdb VARCHAR(50) PRIMARY KEY,
    imdbHref VARCHAR(255),
    nom VARCHAR(255),
    annee INT
);

-- Table Genre
CREATE TABLE Genre (
    nom VARCHAR(100) PRIMARY KEY
);

-- Table Realisateur
CREATE TABLE Realisateur (
    idImdb VARCHAR(50) PRIMARY KEY,
    identite VARCHAR(255),
    href VARCHAR(255),
    anniversaire DATE
);

-- Table Pays
CREATE TABLE Pays (
    nom VARCHAR(100) PRIMARY KEY
);

-- Jointure Film <-> Genre (n-n)
CREATE TABLE Film_Genre (
    film_id VARCHAR(50),
    genre_nom VARCHAR(100),
    PRIMARY KEY (film_id, genre_nom),
    FOREIGN KEY (film_id) REFERENCES Film(idImdb),
    FOREIGN KEY (genre_nom) REFERENCES Genre(nom)
);

-- Jointure Film <-> Realisateur (n-n)
CREATE TABLE Film_Realisateur (
    film_id VARCHAR(50),
    realisateur_id VARCHAR(50),
    PRIMARY KEY (film_id, realisateur_id),
    FOREIGN KEY (film_id) REFERENCES Film(idImdb),
    FOREIGN KEY (realisateur_id) REFERENCES Realisateur(idImdb)
);

-- Jointure Film <-> Pays (n-n)
CREATE TABLE Film_Pays (
    film_id VARCHAR(50),
    pays_nom VARCHAR(100),
    PRIMARY KEY (film_id, pays_nom),
    FOREIGN KEY (film_id) REFERENCES Film(idImdb),
    FOREIGN KEY (pays_nom) REFERENCES Pays(nom)
);

INSERT INTO Film (idImdb, imdbHref, nom, annee)
VALUES ('tt1234567', 'https://www.imdb.com/title/tt1234567/', 'Le Grand Film', 2020),
('tt1111111', 'https://www.imdb.com/title/tt1111111/', 'La biffle du Gévaudan', 2001),
('tt0102030', 'https://www.imdb.com/title/tt0102030/', 'Le roi des Juifs', 1999),
('tt6666666', 'https://www.imdb.com/title/tt1234567/', 'Platistes contre Extraterrestres', 2025);

INSERT INTO Acteur (idImdb, identite, href, anniversaire)
VALUES ('nm0011223', 'Jean Dupont', 'https://www.imdb.com/name/nm0011223/', '1980-04-15'),
('nm0000001', 'Patrick Bruel', 'https://www.imdb.com/name/nm0000001/', '1979-02-14'),
('nm0000011', 'Christophe Dechavanne', 'https://www.imdb.com/name/nm0000011/', '1976-01-15'),
('nm4444444', 'Jean-Louis Borloo', 'https://www.imdb.com/name/nm4444444/', '1969-06-09'),
('nm4444445', 'Jean-Marc Morandini', 'https://www.imdb.com/name/nm4444445/', '1975-01-01'),
('nm0000000', 'Mark Zuckerberg', 'https://www.imdb.com/name/nm0000000/', '1500-01-01'),
('nm0465465', 'José Garcia', 'https://www.imdb.com/name/nm0465465/', '1970-02-13');


INSERT INTO Role (nom, acteur_id, film_id)
VALUES ('Jésus', 'nm0000001', 'tt0102030'),
('Inspecteur Martin', 'nm0011223', 'tt1234567'),
('Le petit Benjamin', 'nm0000011', 'tt1234567'),
('La bête', 'nm4444444', 'tt1111111'), ('L\'enfant', 'nm4444445', 'tt1111111'),
('Mecha Zuck', 'nm0000000', 'tt6666666'), ('J0S3 G4RC14', 'nm0465465', 'tt6666666'), ('Le Prophète', 'nm0000011', 'tt6666666'), ('Zuckinator', 'nm0000000', 'tt6666666'),
('Inspecteur Martin', 'nm0011223', 'tt1234567');

INSERT INTO Genre (nom) VALUES ('Action'), ('Drame'), ('Horreur'), ('Film de boule'), ('Romance'), ('Nanard'), ('Tout public'), ('Futuriste'), ('Science fiction'), ('Navet');

-- Association film-genre
INSERT INTO Film_Genre (film_id, genre_nom)
VALUES ('tt1234567', 'Action'), ('tt1234567', 'Drame'),
('tt1111111', 'Drame'), ('tt1111111', 'Film de boule'), ('tt1111111', 'Horreur'),
('tt0102030', 'Tout public'), ('tt0102030', 'Science fiction'),  ('tt0102030', 'Horreur'),
('tt6666666', 'Action'), ('tt6666666', 'Romance'), ('tt6666666', 'Nanard'), ('tt6666666', 'Navet');

INSERT INTO Realisateur (idImdb, identite, href, anniversaire)
VALUES ('nm0099887', 'Claire Moreau', 'https://www.imdb.com/name/nm0099887/', '1975-09-21'),
('nm0099999', 'Henry Patrack', 'https://www.imdb.com/name/nm0099999/', '1955-02-22'),
('nm0465465', 'José Garcia', 'https://www.imdb.com/name/nm0099887/', '1970-02-13');

INSERT INTO Film_Realisateur (film_id, realisateur_id)
VALUES ('tt1234567', 'nm0099887'),
('tt1111111', 'nm0099999'),
('tt0102030', 'nm0099999'),
('tt6666666', 'nm0465465');

INSERT INTO Pays (nom) VALUES ('France'), ('Israël'), ('Los-Angeles');

INSERT INTO Film_Pays (film_id, pays_nom)
VALUES ('tt1234567', 'France'),
('tt1111111', 'France'),
('tt0102030', 'Israël'),
('tt6666666', 'Los-Angeles');

