/*
Escreva um algoritmo que lê dois valores booleanos (lógicos) 
e então determina se ambos são VERDADEIROS ou FALSOS.
*/
import java.util.Scanner;
public class Exe06{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        boolean valor1, valor2;
        
        System.out.print("Digite o primeiro valor booleano (true/false): ");
        valor1 = teclado.nextBoolean();
        System.out.print("Digite o segundo valor booleano (true/false): ");
        valor2 = teclado.nextBoolean();

        if(valor1 && valor2) {
            System.out.println("Ambos são verdadeiros.");
        }
        else if(!valor1 && !valor2) {
            System.out.println("Ambos são falsos.");
        }
        else{
            System.out.println("Um é verdadeiro e o outro é falso.");
        }
        teclado.close();
    }
}