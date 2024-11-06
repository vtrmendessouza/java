/*
Tendo como dados de entrada a altura e o sexo de uma pessoa, 
construa um algoritmo que calcule seu peso ideal, 
utilizando as seguintes fórmulas:
para homens: (72.7 * h) – 58;
para mulheres: (62.1 * h) – 44.7.
*/
import java.util.Scanner;
public class Exe09{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        double altura = 0, sexo = 0, peso = 0;

        System.out.print("Digite a altura em metros: ");
        altura = teclado.nextDouble();
        System.out.print("Digite 1 para homem ou 2 para mulher: ");
        sexo = teclado.nextDouble();

        if(sexo == 1){
            peso = (72.7 * altura) - 58;
            System.out.printf("Peso ideal: %.1f", peso);
        }
        else{
            peso = (62.1 * altura) - 44.7;
            System .out.printf("Peso ideal: %.1f", peso);
        }
        teclado.close();
    }
}