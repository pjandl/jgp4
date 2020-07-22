
-- Conexao com BD SSolar
CONNECT 'jdbc:derby://localhost:1527/ssolar';

-- Registro do arquivo jar que contem codigo das funcoes
-- e procedimentos que serao criados.
-- Necessario que classe P1011Planeta.class (Exemplo 10.11)
-- esteja no arquivo Planeta.jar, presente no diretorio 
-- de inicializacao da instancia em uso do Derby ou em seu
-- classpath.
CALL SQLJ.install_jar
('Planeta.jar', 'APP.PlanetaJar', 0);

CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY
('derby.database.classpath', 'APP.PlanetaJar');

-- Criacao de funcao armazenada
CREATE FUNCTION funcPosPlaneta
(nomePlaneta VARCHAR(255))
RETURNS INTEGER
PARAMETER STYLE JAVA
LANGUAGE JAVA
READS SQL DATA
EXTERNAL NAME 'jandl.db.P1011Planeta.functionPosicaoDoPlaneta';

-- Criacao de procedimento armazenado
CREATE PROCEDURE procNomePlaneta
(IN posicao INTEGER, OUT nome VARCHAR(255))
PARAMETER STYLE JAVA 
LANGUAGE JAVA
READS SQL DATA
EXTERNAL NAME 'jandl.db.P1011Planeta.procedurePlanetaNaPosicao';

-- Finaliza conexao
DISCONNECT;
