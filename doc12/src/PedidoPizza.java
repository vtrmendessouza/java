/*
Um enum no Java é uma maneira de criar um conjunto de valores fixos e predefinidos 
que representam um conceito específico no seu programa. 
Ele é usado quando você sabe que algo pode ter apenas algumas opções possíveis.
Por exemplo, imagine que você está criando um sistema de pedidos de comida 
e quer representar os tamanhos possíveis de uma pizza: pequeno, médio e grande. 
Em vez de usar strings ou números, você pode usar um enum para garantir 
que só esses valores sejam usados.
Um enum é um tipo especial de classe que define constantes (valores fixos). 
Esses valores são chamados de elementos ou constantes do enum.
Legibilidade: O código fica mais claro, porque você usa nomes significativos 
em vez de números ou strings.
Segurança: Como os valores são fixos, você evita erros como digitar "grande" errado (ex.: "grnade").
Organização: Facilita agrupar valores relacionados em um único lugar.
Facilidade de manutenção: Se precisar adicionar ou alterar um valor, basta ajustar o enum.
*/
public class PedidoPizza {
    //Com isso, você pode usar o TamanhoPizza no seu código para representar os tamanhos possíveis:
    public enum TamanhoPizza {
        PEQUENO,
        MEDIO,
        GRANDE
    }
    public static void main(String[] args) {
        TamanhoPizza tamanho = TamanhoPizza.GRANDE;
        // Verificar o tamanho
        switch (tamanho) {
            case PEQUENO:
                System.out.println("Você escolheu uma pizza pequena.");
                break;
            case MEDIO:
                System.out.println("Você escolheu uma pizza média.");
                break;
            case GRANDE:
                System.out.println("Você escolheu uma pizza grande.");
                break;
        }
    }
}