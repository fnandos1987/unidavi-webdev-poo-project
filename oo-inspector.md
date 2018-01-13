# Encapsulamento

## Defini��o
� a t�cnica utilizada para esconder uma ideia, ou seja, n�o exp�r detalhes internos para o usu�rio, tornando partes do sistema mais independentes poss�vel.

Artigo: Abstra��o, Encapsulamento e Heran�a: Pilares da POO em Java.
Dispon�vel em: http://www.devmedia.com.br/abstracao-encapsulamento-e-heranca-pilares-da-poo-em-java/26366

## Exemplos
Um exemplo dessa defini��o pode ser visto em uma class Conta Corrente. O usu�rio n�o pode ter a possibilidade de alterar seu limite ent�o o atributo deve ser encapsulado de maneira a n�o ser acess�vel.

Artigo: Como n�o aprender Java e Orienta��o a Objetos: getters e setters.
Dispon�vel em: http://blog.caelum.com.br/nao-aprender-oo-getters-e-setters

## Ferramenta
1) Restringe o acesso aos atributos da classe.
2) Evita o uso incorreto e modifica��es na estrutura das classes.
3) Possui m�todos possibilitando acesso as atributos que podem ser conhecidos por outras classes.
4) Prov� m�todos para manipular o estado dos atributos de forma segura.

## Inspe��o
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

# Heran�a

## Defini��o
Heran�a � um princ�pio de orienta��o a objetos, que permite que classes compartilhem atributos e m�todos, atrav�s de "heran�as". Ela � usada na inten��o de reaproveitar c�digo ou comportamento generalizado ou especializar opera��es ou atributos.

Artigo: Heran�a (programa��o)
Dispon�vel em: https://pt.wikipedia.org/wiki/Heran%C3%A7a_(programa%C3%A7%C3%A3o)

## Exemplos
SuperClasse Funcion�rio possuindo os atributos nome e sal�rio e a classe Secret�ria possuindo al�m do nome e sal�rio da superclasse o atributo ramal.

Artigo: Abstra��o, Encapsulamento e Heran�a: Pilares da POO em Java.
Dispon�vel em: http://www.devmedia.com.br/abstracao-encapsulamento-e-heranca-pilares-da-poo-em-java/26366

## Ferramenta
1) Extender superclasse
2) Reusar sen�o toda ao menos a maior parte de interface provida para superclasse.

## Inspe��o
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
1 - N�o.
2 - N�o

# Polimorfismo

## Defini��o
Polimorfismo Sobreescrita: A Sobrescrita de M�todos pode ser classificada como polimorfismo de inclus�o. Quando um m�todo sobrescreve um m�todo herdado de uma classe, temos uma sobrescrita de m�todo. Este m�todo de sobrescrita tem que ser id�ntico ao m�todo da classe herdada, ou seja, eles precisam ter o mesmo nome, valor de retorno e argumentos. Dispon�vel em : http://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140

Polimorfismo Sobrecarga: O tipo de polimorfismo de Sobrecarga permite a exist�ncia de v�rios m�todos de mesmo nome, por�m com assinaturas levemente diferentes, ou seja, variando no n�mero e tipo de argumentos. Ficaria a cargo do compilador escolher de acordo com as listas de argumentos os procedimentos ou m�todos a serem executados. Dispon�vel em : http://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140

Polimorfismo de Inclus�o: um ponteiro para classe m�e pode apontar para uma inst�ncia de uma classe filha (exemplo em Java: List lista = new LinkedList(); (tipo de polimorfismo mais b�sico que existe). Dispon�vel em: https://pt.wikipedia.org/wiki/Polimorfismo

Polimorfismo Param�trico: Em linguagens de programa��o e teoria dos tipos, polimorfismo param�trico � uma forma de se tornar uma linguagem mais expressiva, enquanto continua mantendo toda sua tipagem est�tica segura. Usando o polimorfismo param�trico, a fun��o ou tipo de dado pode ser escrita genericamente para que possa suportar valores id�nticos sem depender de seu tipo.[1] Essas fun��es e tipos de dados s�o chamados fun��es gen�ricas e tipos de dados gen�ricos respectivamente e formam a base da programa��o gen�rica. Dispon�vel em: https://pt.wikipedia.org/wiki/Polimorfismo_param%C3%A9trico

## Exemplos
Class OperacaoMatematica possui o m�todo abstrato calcular que recebe dois par�metros, essa classe � extendida pelas classes Soma e Subtracao sendo que soma implementa o m�todo calcular somando os dois par�metros e a classe Subtracao diminui o segundo par�metro do primeiro. 

Artigo: Polimorfismo
Dispon�vel em: https://pt.wikipedia.org/wiki/Polimorfismo

GenericDao polimorfismo param�trico.
Artigo: Don't repeat the DAO!
Dispon�vel em: https://www.ibm.com/developerworks/library/j-genericdao/index.html


## Ferramenta
1) Possuir m�todos da superclasse com comportamento diferenciado.

## Inspe��o
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
