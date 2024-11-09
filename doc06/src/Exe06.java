/*
Desafio: Algoritmo Caixa Eletrônico
Aqui temos a implementação do algoritmo do caixa eletronico 
utilizando um laço para identificar a quantidade de notas a serem sacadas.
Este código não está considerando a existência de notas de 200 reais e notas de 2 reais. 
Faça as modificações necessárias para implementar a possibilidade do caixa eletronico 
forneceder notas de 200 e também notas de 2.
Este código possui um problema, caso o usuário digite um valor 
que não possa ser fornecido com as notas disponíveis, 
o laco entra em uma situação conhecida como looping infinito, 
ou seja o programa nunca terminará. 
Se você testar o código com o valor 48 reais esta situação de looping ocorrerá. 
Para corrigir este cenário, implemente uma função que seja responsável 
pela leitura do valor a ser sacado, 
e esta função deve garantir que o usuário digite um valor que 
seja múltiplo da menor nota que o caixa eletrônico tenha disponível.
Depois das implementações anteriores, 
modifique o algoritmo do caixa eletrônico para que ele possa ser 
iniciado com a quantidade de notas disponíveis no caixa. 
Este valor deve ser informado pelo usuário no início da execução do algoritmo. 
Posteriormente o algoritmo deve entrar em uma repetição sucessiva, 
realizando a leitura de vários saques informados pelo usuário. 
Após o usuário informar que deseja fazer o saque e o algoritmo deve mostrar 
a quantidade de notas que serão sacadas, 
e deve descontar a quantidade de notas fornecidas do montante de notas existentes internamente, 
para que o próximo saque possa ser realizado. O algoritmo após este ponto, 
perguntará se deseja realizar um novo saque e todo o procedimento se repete. 
O algoritmo finaliza quando o usuário informar que não deseja realizar novos saques. 
Caso o usuário solicite um saque que não possa ser atendido 
por não ter a quantidade de notas necessárias, 
deve ser exibido uma mensagem informando tal situação. 
No término da execução o algoritmo deve aprensentar a quantidade de notas restantes na máquina 
e qual o valor total disponível na máquina.
*/
import java.util.Scanner;
public class Exe06 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o valor do saque
        System.out.print("Digite o valor que deseja sacar: R$ ");
        int valorSaque = scanner.nextInt();

        // Variáveis para a quantidade de cada nota
        int nota100 = 0, nota50 = 0, nota20 = 0, nota10 = 0, nota5 = 0;

        // Laço do-while para processar o saque
        do {
            if (valorSaque >= 100) {
                nota100++;
                valorSaque -= 100;
            } else if (valorSaque >= 50) {
                nota50++;
                valorSaque -= 50;
            } else if (valorSaque >= 20) {
                nota20++;
                valorSaque -= 20;
            } else if (valorSaque >= 10) {
                nota10++;
                valorSaque -= 10;
            } else if (valorSaque >= 5) {
                nota5++;
                valorSaque -= 5;
            }
        } while (valorSaque > 0); // Continua enquanto houver valor a ser sacado

        // Exibir o resultado
        System.out.println("Notas a serem fornecidas:");
        if (nota100 > 0) System.out.println(nota100 + " nota(s) de R$ 100");
        if (nota50 > 0) System.out.println(nota50 + " nota(s) de R$ 50");
        if (nota20 > 0) System.out.println(nota20 + " nota(s) de R$ 20");
        if (nota10 > 0) System.out.println(nota10 + " nota(s) de R$ 10");
        if (nota5 > 0) System.out.println(nota5 + " nota(s) de R$ 5");

        // Se restar algum valor menor que 5, ele não pode ser atendido com as notas disponíveis
        if (valorSaque > 0) {
            System.out.println("Valor restante não pode ser atendido com as notas disponíveis.");
        }

        scanner.close();
    }
}    
