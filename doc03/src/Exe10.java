/*
Exercício 10: 
Leia um valor e apresente uma frase que diga se o número é: 
par ou ímpar e positivo ou negativo. Caso o valor seja 0, mostre a mensagem: O número digitado é neutro.
Exemplo 01:
Digite o número: 5
O número 5 é impar e positivo.
Exemplo 02:
Digite o número: -6
O número -6 é par e negativo.
Exemplo 03: 
Digite o número: 0
O número digitado é neutro.
*/
import java.util.Scanner;
public class Exe10{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int numero = 0, par = 0, positivo = 0;

        System.out.print("Informe o número desejado: ");
        numero = teclado.nextInt();
        teclado.nextLine();

        if(numero % 2 == 0){
            par = 1;
        }
        if(numero > 0){
            positivo = 1;
        }
        if(numero == 0){
            positivo = 2;
        }
        if(positivo == 2){
            System.out.printf("O número %d é nêutro.", numero);
            System.exit(0);
            teclado.close();
        }
        else if(par == 1 && positivo == 1){
            System.out.printf("O número %d é par e positivo.", numero);
            System.exit(0);
            teclado.close();
        }
        else if(par == 0 && positivo == 0){
            System.out.printf("O número %d é ímpar e negativo.", numero);
            System.exit(0);
            teclado.close();
        }
        else if(par == 1 && positivo == 0){
            System.out.printf("O número %d é par e negativo.", numero);
            System.exit(0);
            teclado.close();
        }
        else if(par == 0 && positivo == 1){
            System.out.printf("O número %d é ímpar e positivo.", numero);
            System.exit(0);
            teclado.close();
        }
    }
}