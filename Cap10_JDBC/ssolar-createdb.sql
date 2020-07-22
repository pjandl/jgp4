
-- Conexao com BD SSolar
-- CONNECT 'jdbc:derby://localhost:1527/ssolar;create=true';

-- Criacao da tabela PLANETAS
CREATE TABLE planetas (
    posicao int primary key,
    nome char(10),
    distancia float,
    diametro float
);

-- Insercao de dados na tabela
INSERT INTO planetas VALUES (1, 'Mercurio',  57.9,   4988.9);
INSERT INTO planetas VALUES (2, 'Venus',    108.1,  12391.9);
INSERT INTO planetas VALUES (3, 'Terra',    149.5,  12757.2);
INSERT INTO planetas VALUES (4, 'Marte',    227.7,   6783.3);
INSERT INTO planetas VALUES (5, 'Jupiter',  777.6, 142652.5);
INSERT INTO planetas VALUES (6, 'Saturno', 1425.7, 119652.5);
INSERT INTO planetas VALUES (7, 'Urano',   2867.8,  51499.1);
INSERT INTO planetas VALUES (8, 'Netuno',  4494.9,  44643.2);
INSERT INTO planetas VALUES (9, 'Plutao',  5906.3,   5793.6);

-- Criacao tabela REVOLUCAO
CREATE TABLE revolucao (
    posicao int primary key,
    sideral float,
    sinodico float,
    rotacao float
);

-- Insercao de dados na tabela
INSERT INTO revolucao VALUES (1,    88.0,  115.9, 2112.0);
INSERT INTO revolucao VALUES (2,   224.7,  583.9,  720.0);
INSERT INTO revolucao VALUES (3,   365.3,    0.0,   23.93);
INSERT INTO revolucao VALUES (4,   687.0,  779.9,   24.62);
INSERT INTO revolucao VALUES (5,  4343.5,  398.9,    9.83);
INSERT INTO revolucao VALUES (6, 10767.5,  378.1,   10.23);
INSERT INTO revolucao VALUES (7, 30660.0,  369.7,   10.75);
INSERT INTO revolucao VALUES (8, 60152.0,  367.5,   15.8);
INSERT INTO revolucao VALUES (9, 90410.5,  366.7,   -1.0);

-- Criacao tabela SATELITES
CREATE TABLE satelites (
	posicao int,
	nome char(20)
);

-- Insercao de dados na tabela
INSERT INTO satelites VALUES (3, 'Lua');
INSERT INTO satelites VALUES (4, 'Fobos');
INSERT INTO satelites VALUES (4, 'Deimos');
INSERT INTO satelites VALUES (5, 'Io');
INSERT INTO satelites VALUES (5, 'Europa');
INSERT INTO satelites VALUES (5, 'Ganimedes');
INSERT INTO satelites VALUES (5, 'Calisto');
INSERT INTO satelites VALUES (5, 'Amalteia');
INSERT INTO satelites VALUES (5, 'VI');
INSERT INTO satelites VALUES (5, 'VII');
INSERT INTO satelites VALUES (5, 'VIII');
INSERT INTO satelites VALUES (5, 'IX');
INSERT INTO satelites VALUES (5, 'X');
INSERT INTO satelites VALUES (5, 'XI');
INSERT INTO satelites VALUES (5, 'XII');
INSERT INTO satelites VALUES (6, 'Titan');
INSERT INTO satelites VALUES (6, 'Japeto');
INSERT INTO satelites VALUES (6, 'Reia');
INSERT INTO satelites VALUES (6, 'Tetis');
INSERT INTO satelites VALUES (6, 'Dione');
INSERT INTO satelites VALUES (6, 'Minas');
INSERT INTO satelites VALUES (6, 'Encelado');
INSERT INTO satelites VALUES (6, 'Hiperion');
INSERT INTO satelites VALUES (6, 'Febo');
INSERT INTO satelites VALUES (7, 'Titania');
INSERT INTO satelites VALUES (7, 'Oberon');
INSERT INTO satelites VALUES (7, 'Ariel');
INSERT INTO satelites VALUES (7, 'Umbriel');
INSERT INTO satelites VALUES (7, 'Miranda');
INSERT INTO satelites VALUES (8, 'Tritao');
INSERT INTO satelites VALUES (8, 'Nereida');

-- Finaliza conexao
-- DISCONNECT;
