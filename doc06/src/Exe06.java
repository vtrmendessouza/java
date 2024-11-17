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
import java.util.InputMismatchException;
public class Exe06{
    public static void main(String[] args)throws Exception{
        Scanner scanner = new Scanner(System.in);
        int valorSaque = 0, nota200 = 0, nota100 = 0, nota50 = 0, nota20 = 0, nota10 = 0, nota5 = 0, nota2 = 0;
        String resposta = "";
        boolean flag = true;
        
        System.out.println("Bem vindo!");
        //sacar novamente
        do{
            if(resposta.equals("s")){
                System.out.println("Bem vindo novamente!");
                valorSaque = 0;
            }
            //alterar saque
            do{
                //try catch
                do{
                    if(valorSaque != 0){
                        System.out.printf("Escolha um valor diferente de: R$ %d\n", valorSaque);
                    }
                    System.out.print("Digite o valor que deseja sacar: R$ ");

                    try{
                        valorSaque = scanner.nextInt();
                        scanner.nextLine();
                        flag = false;
                    }
                    catch(InputMismatchException varInputMismatchException){
                        System.out.println("Dado incorreto.");
                        scanner.nextLine();
                    }
                //try catch
                }while (flag);
                
                nota200 = valorSaque / 200;
                valorSaque -= nota200 * 200;
                nota100 = valorSaque / 100;
                valorSaque -= nota100 * 100;
                nota50 = valorSaque / 50;
                valorSaque -= nota50 * 50;
                nota20 = valorSaque / 20;
                valorSaque -= nota20 * 20;
                nota10 = valorSaque / 10;
                valorSaque -= nota10 * 10;
                nota5 = valorSaque / 5;
                valorSaque -= nota5 * 5;
                nota2 = valorSaque / 2;
                valorSaque -= nota2 * 2;
                
                if(valorSaque > 0){
                    System.out.println ("O valor solicitado não pode ser fornecido.");
                }
            //alterar saque
            }while(valorSaque > 0);
            
            System.out.println("Notas a serem fornecidas:");
            if(nota200 > 0) System.out.println(nota200 + " nota(s) de R$ 200");
            if(nota100 > 0) System.out.println(nota100 + " nota(s) de R$ 100");
            if(nota50 > 0) System.out.println(nota50 + " nota(s) de R$ 50");
            if(nota20 > 0) System.out.println(nota20 + " nota(s) de R$ 20");
            if(nota10 > 0) System.out.println(nota10 + " nota(s) de R$ 10");
            if(nota5 > 0) System.out.println(nota5 + " nota(s) de R$ 5");
            if(nota2 > 0) System.out.println(nota2 + " nota(s) de R$ 2");
            //resposta de novo saque invalida
            do{
                System.out.print("Deseja realizar outro saque? s/n: ");
                resposta = scanner.nextLine();

                if (!resposta.equals("s") && !resposta.equals("n")){
                    System.out.println("Opção inválida.");
                }
            //resposta de novo saque invalida
            }while(!resposta.equals("s") && !resposta.equals("n"));
        //sacar novamente
        }while(resposta.equals("s"));
        System.out.println("Operação encerrada.");
        scanner.close();
    }
}