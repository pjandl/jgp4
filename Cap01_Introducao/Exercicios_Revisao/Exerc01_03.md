# Capítulo 1::Exercício 3

A máquina virtual Java (**JVM**) é, de fato, a especificação de um computador virtual destinado a execução de programas Java. Nesta especificação são definidas as instruções deste computador, conhecidas como **bytecodes**, assim como o efeito preciso de cada uma destas instruções. Uma JVM pode ser contruída/implementada para, praticamente, qualquer plataforma computacional, ou seja, para qualquer combinação de hardware e sistema operacional, de maneira que seja possível a execução dos bytecodes nestas plataformas, ou seja, o papel da JVM é executar os programas Java (os arquivos *.class*).

Essa é razão dos programas Java serem compilados neste formato específico denominado **bytecode**, que é independente do hardware do computador e de seu sistema operacional.

A JVM lê os arquivos de extensão *.class* interpretando suas instruções, sem necessidade do programa ser modificado ou recompilado, mesmo que esteja sendo executado num computador diferente daquele onde foi gerado.

Referência (seção):  1.3, 1.4
