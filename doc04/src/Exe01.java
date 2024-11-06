/*
Faça um algoritmo que leia os valores A, B, C 
e imprima na tela se a soma de A + B é menor que C.
*/
import java.util.Scanner;
public class Exe01{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float a = 0, b = 0, c = 0;
        
        System.out.print("Informe o valor de A: ");
        a = teclado.nextFloat();
        System.out.print("Informe o Informe o valor de B: ");
        b = teclado.nextFloat();
        System.out.print("Informe o Informe o valor de C: ");
        c = teclado.nextFloat();
        
        if(a + b < c){
            System.out.print("A + B é menor que C.");
            }
        else{
            System.out.print("A + B não é menor que C.");
            }
        teclado.close();
    }
}