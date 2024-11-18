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
        int nota200 = 0, nota100 = 0, nota50 = 0, nota20 = 0, nota10 = 0, nota5 = 0, nota2 = 0;
        int estoque200 = 0, estoque100 = 0, estoque50 = 0, estoque20 = 0, estoque10 = 0, estoque5 = 0, estoque2 = 0;
        int estoque = 0, saque = 0, caixa = 0;
        String repetir = "";

        estoque = lerInt(scanner, "Informe a quantidade de notas a serem abastecidas: ");
        estoque200 = estoque;
        estoque100 = estoque;
        estoque50 = estoque;
        estoque20 = estoque;
        estoque10 = estoque;
        estoque5 = estoque;
        estoque2 = estoque;

        do{
            do{
                saque = lerInt(scanner, "Digite o valor que deseja sacar: R$ ");
                
                estoque200 += nota200;
                nota200 = 0; 
                estoque100 += nota100;
                nota100 = 0;
                estoque50 += nota50;
                nota50 = 0;
                estoque20 += nota20;
                nota20 = 0;
                estoque10 += nota10;
                nota10 = 0;
                estoque5 += nota5;
                nota5 = 0;
                estoque2 += nota2;
                nota2 = 0;
                
                while(saque >= 200 && estoque200 > 0){
                    saque -= 200;
                    nota200 ++;
                    estoque200 --;
                }
                while(saque >= 100 && estoque100 > 0){
                    saque -= 100;
                    nota100 ++;
                    estoque100 --;
                }
                while(saque >= 50 && estoque50 > 0){
                    saque -= 50;
                    nota50 ++;
                    estoque50 --;
                }
                while(saque >= 20 && estoque20 > 0){
                    saque -= 20;
                    nota20 ++;
                    estoque20 --;
                }
                while(saque >= 10 && estoque10 > 0){
                    saque -= 10;
                    nota10 ++;
                    estoque10 --;
                }
                while(saque >= 5 && estoque5 > 0){
                    saque -= 5;
                    nota5 ++;
                    estoque5 --;
                }
                while(saque >= 2 && estoque2 > 0){
                    saque -= 2;
                    nota2 ++;
                    estoque2 --;
                }
                if(saque > 0){
                    System.out.println("O valor solicitado não pode ser fornecido.");
                    System.out.printf("Faltou: R$ %d,00 \n", saque);
                }
            }
            while(saque > 0);
            
            System.out.println("Notas a serem fornecidas:");
            if(nota200 > 0) System.out.println(nota200 + " nota(s) de R$ 200");
            if(nota100 > 0) System.out.println(nota100 + " nota(s) de R$ 100");
            if(nota50 > 0) System.out.println(nota50 + " nota(s) de R$ 50");
            if(nota20 > 0) System.out.println(nota20 + " nota(s) de R$ 20");
            if(nota10 > 0) System.out.println(nota10 + " nota(s) de R$ 10");
            if(nota5 > 0) System.out.println(nota5 + " nota(s) de R$ 5");
            if(nota2 > 0) System.out.println(nota2 + " nota(s) de R$ 2");
            
            repetir = lerString(scanner, "Deseja realizar outro saque? s/n: ");
        }
        while(repetir.equals("s"));
        
        caixa = estoque200 * 200 + estoque100 * 100 + estoque50 * 50 +
                    estoque20 * 20 + estoque10 * 10 + estoque5 * 5 + estoque2 * 2;

        System.out.println("Notas disponíveis:");
        System.out.println(estoque200 + " nota(s) de R$ 200");
        System.out.println(estoque100 + " nota(s) de R$ 100");
        System.out.println(estoque50 + " nota(s) de R$ 50");
        System.out.println(estoque20 + " nota(s) de R$ 20");
        System.out.println(estoque10 + " nota(s) de R$ 10");
        System.out.println(estoque5 + " nota(s) de R$ 5");
        System.out.println(estoque2 + " nota(s) de R$ 2");
        System.out.printf("Saldo disponível: R$ %d,00\n", caixa);
        
        scanner.close();
    }
    static int lerInt(Scanner scanner, String mensagem){
        int valorInt = 0;
        boolean flag = false;
        do{
            try {
                System.out.print(mensagem);
                valorInt = scanner.nextInt();
                flag = true;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                scanner.nextLine();
            }
        }
        while(!flag);
        return valorInt;
    }
    static String lerString(Scanner scanner, String mensagem){
        String str = "";
        do{
            System.out.print(mensagem);
            scanner.nextLine();
            str = scanner.nextLine();

            if (!str.equals("s") && !str.equals("n")){
                System.out.println("Opção inválida.");
            }
        }
        while(!str.equals("s") && !str.equals("n"));
        return str;
    }
}