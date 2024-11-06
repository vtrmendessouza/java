/*
Exercício 11: 
Faça um Programa para um caixa eletrônico. 
O programa deverá perguntar ao usuário a valor do saque 
e depois informar quantas notas de cada valor serão fornecidas. 
As notas disponíveis serão as de 1, 5, 10, 50 e 100 reais. 
O valor mínimo é de 10 reais e o máximo de 600 reais. 
O programa não deve se preocupar com a quantidade de notas existentes na máquina.
Exemplo 1: Para sacar a quantia de 256 reais, 
o programa fornece duas notas de 100, uma nota de 50, uma nota de 5 e uma nota de 1;
Exemplo 2: Para sacar a quantia de 399 reais, 
o programa fornece três notas de 100, uma nota de 50, quatro notas de 10, uma nota de 5 e quatro notas de 1.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Exe11{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int valor = 0, cedula1 = 0, cedula5 = 0, cedula10 = 0, cedula50 = 0, cedula100 = 0;

        do{
            try{
                System.out.print("informe um valor inteiro entre 10 e 600: ");
                valor = teclado.nextInt();
               teclado.nextLine();
                if(valor > 600 || valor < 10){
                System.out.print("Valor inválido.\n");
                }
            }
            catch(InputMismatchException variavelDivergente){
                System.out.print("Valor inválido.\n");
                teclado.nextLine();
            }
        }
        while(valor > 600 || valor < 10);

        cedula100 = valor / 100;
        cedula50 = (valor % 100) / 50;
        cedula10 = (valor % 50) / 10;
        cedula5 = (valor % 10) / 5;
        cedula1 = valor % 5;

        System.out.printf("Notas de 100: %d\n", cedula100);
        System.out.printf("Notas de 50: %d\n", cedula50);
        System.out.printf("Notas de 10: %d\n", cedula10);
        System.out.printf("Notas de 5: %d\n", cedula5);
        System.out.printf("Notas de 1: %d\n", cedula1);

        teclado.close();
        System.exit(0);
    }
}