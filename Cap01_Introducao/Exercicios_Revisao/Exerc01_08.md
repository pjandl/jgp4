# Capítulo 1::Exercício 8

Uma *variável de ambiente* é um valor mantido pelo sistema operacional, geralmente expresso como texto, associado a um nome específico, de maneira que tal valor possa ser dinamicamente recuperado por programas e pelo próprio sistema operacional. Tais valor permitem configurar e ajustar o modo como os processos e pogramas em execução irão se comportar em um computador.

Para que o Java e suas aplicações funcionem corretamente em um computador é necessário o ajuste de duas *variáveis de ambiente*, que são **PATH** e **CLASSPATH**.

A variável de ambiente **PATH** é encontrada na maioria dos sistemas operacionais, tendo como finalidade listar os diretórios onde o sistema operacional buscará programas
ou comandos para execução. Esta variável pode ser modificada para adicionar o diretório em que estão instaladas as ferramentas do JavaSE.

A variável de ambiente **CLASSPATH** é usada pela especificamente pela plataforma Java para listar os diretórios nos quais existem classes e pacotes que serão utilizados pelas aplicações Java em execução no sistema, permitindo sua organização em
diferentes diretórios do sistema. Quando não encontrada, a JVM utiliza o valor padrão "." (ponto, caractere que indica o diretório atual) configurando a máquina virtual para buscar classes e pacotes no diretório inicial de execução do programa. O uso correto de **CLASSPATH** evita a duplicação de classes e pacotes comuns usados por diferentes aplicações Java.

Referência (seção): 1.6
