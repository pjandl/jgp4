# Capítulo 3::Exercício 2

O especificador de acesso *public* não impõe qualquer restrição de acesso aos membros de uma classe, ou seja, seu uso torna públicos os membros assim especificados, tanto para instâncias da classe, como suas subclasses e suas instâncias.

O especificador de acesso *private* faz com que os membros assim declarados só possam ser usados dentro da implementação da própria classe. Membros privados não podem ser acessados por instâncias da classe, nem por sub-classes e suas instâncias.

O especificador de acesso *protected* impede que instâncias da classe e instâncias das subclasses possam usar os membros assim declarados, mas permite que as implementações das subclasses possam acessar membros protegidos.

Referência (seção): 3.1.1
