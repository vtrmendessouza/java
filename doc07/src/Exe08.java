/*
08: Faça um algoritmo que leia 6 números inteiros. 
Após a leitura deve ser mostrado na tela qual é o maior e o menor número digitado.
*/

import java.util.Scanner;

public class Exe08 {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        int numero = 0, maior = 0, menor = 0;
        
        for(int i = 0; i < 6; i++){
            System.out.printf("Digite um número inteiro: ");
            numero = teclado.nextInt();
            if(i == 0){
                maior = numero;
                menor = numero;
            }
            else if(i != 0 && numero > maior){
                maior = numero;
            }
            else if (i != 0 && numero < menor){
                menor = numero;
            }
        }
        System.out.printf("Maior: %d\n", maior);
        System.out.printf("Menor: %d\n", menor);
        teclado.close();
    }    
}