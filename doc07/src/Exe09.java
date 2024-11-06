/*
09: Faça um algoritmo que leia uma quantidade desconhecida de números 
e conte quantos deles estão nos seguintes intervalos: 
de 0 a 25; de 26 a 50; de 51 a 75; de 76 a 100. 
A entrada de dados deve terminar quando for lido um número negativo.
*/

import java.util.Scanner;

public class Exe09 {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        int numero = 0, numero25 = 0, numero50 = 0, numero75 = 0, numero100 = 0;
        
        while(numero >= 0){
            System.out.printf("Digite um número: ");
            numero = teclado.nextInt();
            if(numero >= 0 && numero < 26){
                numero25 ++;
            }
            else if(numero > 25 && numero < 51){
                numero50 ++;
            }
            else if(numero > 50 && numero < 76){
                numero75 ++;
            }
            else if(numero > 75 && numero < 101){
                numero100 ++;
            }
        }
        System.out.printf("Entre 0 e 25: %d\n", numero25);
        System.out.printf("Entre 26 e 50: %d\n", numero50);
        System.out.printf("Entre 51 e 75: %d\n", numero75);
        System.out.printf("Entre 76 e 100: %d\n", numero100);
        teclado.close();
    }
}