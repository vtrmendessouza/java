/*
Encontrar o dobro de um número caso ele seja positivo 
e o seu triplo caso seja negativo, imprimindo o resultado.
*/
import java.util.Scanner;
public class Exe05{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float numeroInicial = 0, numeroFinal;
        
        System.out.print("informe um número diferente de zero: ");
        numeroInicial = teclado.nextFloat();
        
        if(numeroInicial > 0){
            numeroFinal = numeroInicial * 2;
            System.out.printf("Resultado: %.2f", numeroFinal);
            }
        else if(numeroInicial < 0){
            numeroFinal = numeroInicial * 3;
            System.out.printf("Resultado: %.2f", numeroFinal);
            }
        teclado.close();
    }
}