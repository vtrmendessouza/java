/*
Faça um algoritmo que leia uma variável 
e some 5 caso seja par ou some 8 caso seja ímpar, 
imprimir o resultado desta operação.
*/
import java.util.Scanner;
public class Exe07{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float numeroInicial = 0, numeroFinal = 0;
        
        System.out.print("informe um número: ");
        numeroInicial = teclado.nextFloat();
        
        if(numeroInicial % 2 == 0){
            numeroFinal = numeroInicial + 5;
            System.out.printf("Resultado: %.2f", numeroFinal);
            }
        else if(numeroInicial % 2 != 0){
            numeroFinal = numeroInicial + 8;
            System.out.printf("Resultado: %.2f", numeroFinal);
            }
        teclado.close();
    }
}