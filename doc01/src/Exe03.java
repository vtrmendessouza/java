import java.util.Scanner;
public class Exe03{
	public static void main(String[] args){
        /*
        Medidor de Temperatura:
        Desenvolva um algoritmo que leia uma temperatura
        e exiba uma informação dizendo se a pessoa está com febre
        caso a temperatura informada for maior que 38 graus.
        */
        Scanner teclado = new Scanner(System.in);
        int temperatura = 0;
            
        System.out.print("informe a temperatura: ");
        temperatura = teclado.nextInt();

        if(temperatura > 38){
            System.out.print("com febre");
        }
        else{
            System.out.print("sem febre");
        }
        teclado.close();
    }
}