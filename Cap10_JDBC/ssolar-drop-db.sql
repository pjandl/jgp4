
-- Conexao com BD SSolar
-- CONNECT 'jdbc:derby://localhost:1527/ssolar';

-- Remocao das tabelas do banco de dados
DROP TABLE planetas;
DROP TABLE revolucao;
DROP TABLE satelites;

-- Remocao das funcoes e procedimentos do banco de dados
DROP PROCEDURE procNomePlaneta;
DROP FUNCTION funcPosPlaneta;

-- Remocao do registro do jar onde se encontra codigo
-- Java correspondente as funcoes e procedimentos
CALL SQLJ.remove_jar
('APP.PlanetaJar', 0);

CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY
('derby.database.classpath', '');

-- Finaliza conexao
-- DISCONNECT;
