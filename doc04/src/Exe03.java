/*
Faça um algoritmo para receber um número qualquer 
e informar na tela se é par ou ímpar.
*/
import java.util.Scanner;
public class Exe03{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float numero = 0;
        
        System.out.print("Informe um número inteiro: ");
        numero = teclado.nextFloat();
        
        if(numero % 2 == 0){
            System.out.print("O número informado é par.");
            }
        else{
            System.out.print("O número informado é ímpar");
            }
        teclado.close();
    }
}