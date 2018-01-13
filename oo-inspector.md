# Encapsulamento

## Definição
É a técnica utilizada para esconder uma ideia, ou seja, não expôr detalhes internos para o usuário, tornando partes do sistema mais independentes possível.

Artigo: Abstração, Encapsulamento e Herança: Pilares da POO em Java.
Disponível em: http://www.devmedia.com.br/abstracao-encapsulamento-e-heranca-pilares-da-poo-em-java/26366

## Exemplos
Um exemplo dessa definição pode ser visto em uma class Conta Corrente. O usuário não pode ter a possibilidade de alterar seu limite então o atributo deve ser encapsulado de maneira a não ser acessível.

Artigo: Como não aprender Java e Orientação a Objetos: getters e setters.
Disponível em: http://blog.caelum.com.br/nao-aprender-oo-getters-e-setters

## Ferramenta
1) Restringe o acesso aos atributos da classe.
2) Evita o uso incorreto e modificações na estrutura das classes.
3) Possui métodos possibilitando acesso as atributos que podem ser conhecidos por outras classes.
4) Provê métodos para manipular o estado dos atributos de forma segura.

## Inspeção
1 - br.edu.unidavi.oscar.model.Categoria:
1) Sim
2) Sim
3) Sim
4) Sim

2 - br.edu.unidavi.oscar.model.Elenco:
1) Sim
2) Sim
3) sim
4) Sim

3 - br.edu.unidavi.oscar.model.ElencoPk:
1) Sim
2) Sim
3) Sim
4) Sim

4 - br.edu.unidavi.oscar.model.Filme:
1) Sim
2) Sim
3) Sim 
4) Sim

5 - br.edu.unidavi.oscar.model.Indicacao:
1) Sim
2) Sim
3) Sim
4) Sim

# Herança

## Definição
Herança é um princípio de orientação a objetos, que permite que classes compartilhem atributos e métodos, através de "heranças". Ela é usada na intenção de reaproveitar código ou comportamento generalizado ou especializar operações ou atributos.

Artigo: Herança (programação)
Disponível em: https://pt.wikipedia.org/wiki/Heran%C3%A7a_(programa%C3%A7%C3%A3o)

## Exemplos
SuperClasse Funcionário possuindo os atributos nome e salário e a classe Secretária possuindo além do nome e salário da superclasse o atributo ramal.

Artigo: Abstração, Encapsulamento e Herança: Pilares da POO em Java.
Disponível em: http://www.devmedia.com.br/abstracao-encapsulamento-e-heranca-pilares-da-poo-em-java/26366

## Ferramenta
1) Extender superclasse
2) Reusar senão toda ao menos a maior parte de interface provida para superclasse.

## Inspeção
1 - br.edu.unidavi.oscar.persistence.Categoria:
1) Sim
2) Sim

2 - br.edu.unidavi.oscar.persistence.Indicacao:
1) Sim
2) Sim

3 - br.edu.unidavi.oscar.dao.Filme
1) Sim
2) Sim

4 - br.edu.unidavi.oscar.persistence.Pessoa:
1) Sim
2) Sim

5 - br.edu.unidavi.oscar.persistence.Elenco:
1 - Não.
2 - Não

# Polimorfismo

## Definição
Polimorfismo Sobreescrita: A Sobrescrita de Métodos pode ser classificada como polimorfismo de inclusão. Quando um método sobrescreve um método herdado de uma classe, temos uma sobrescrita de método. Este método de sobrescrita tem que ser idêntico ao método da classe herdada, ou seja, eles precisam ter o mesmo nome, valor de retorno e argumentos. Disponível em : http://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140

Polimorfismo Sobrecarga: O tipo de polimorfismo de Sobrecarga permite a existência de vários métodos de mesmo nome, porém com assinaturas levemente diferentes, ou seja, variando no número e tipo de argumentos. Ficaria a cargo do compilador escolher de acordo com as listas de argumentos os procedimentos ou métodos a serem executados. Disponível em : http://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140

Polimorfismo de Inclusão: um ponteiro para classe mãe pode apontar para uma instância de uma classe filha (exemplo em Java: List lista = new LinkedList(); (tipo de polimorfismo mais básico que existe). Disponível em: https://pt.wikipedia.org/wiki/Polimorfismo

Polimorfismo Paramêtrico: Em linguagens de programação e teoria dos tipos, polimorfismo paramétrico é uma forma de se tornar uma linguagem mais expressiva, enquanto continua mantendo toda sua tipagem estática segura. Usando o polimorfismo paramétrico, a função ou tipo de dado pode ser escrita genericamente para que possa suportar valores idênticos sem depender de seu tipo.[1] Essas funções e tipos de dados são chamados funções genéricas e tipos de dados genéricos respectivamente e formam a base da programação genérica. Disponível em: https://pt.wikipedia.org/wiki/Polimorfismo_param%C3%A9trico

## Exemplos
Class OperacaoMatematica possui o método abstrato calcular que recebe dois parâmetros, essa classe é extendida pelas classes Soma e Subtracao sendo que soma implementa o método calcular somando os dois parâmetros e a classe Subtracao diminui o segundo parâmetro do primeiro. 

Artigo: Polimorfismo
Disponível em: https://pt.wikipedia.org/wiki/Polimorfismo

GenericDao polimorfismo paramêtrico.
Artigo: Don't repeat the DAO!
Disponível em: https://www.ibm.com/developerworks/library/j-genericdao/index.html


## Ferramenta
1) Possuir métodos da superclasse com comportamento diferenciado.

## Inspeção
1 - br.edu.unidavi.oscar.controller.ListarIndicacoes:
1) Sim

1 - br.edu.unidavi.oscar.controller.ListarFilmes:
1) Sim

1 - br.edu.unidavi.oscar.controller.ListarVencedores:
1) Sim

1 - br.edu.unidavi.oscar.controller.ListarCategoria:
1) Sim

1 - br.edu.unidavi.oscar.controller.DetalharPessoa:
1) Sim
