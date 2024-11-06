/*
O IMC – Indice de Massa Corporal é um critério da Organização Mundial de Saúde 
para dar uma indicação sobre a condição de peso de uma pessoa adulta. 
A fórmula é IMC = peso / ( altura )2 
Elabore um algoritmo que leia o peso e a altura de um adulto 
e mostre sua condição de acordo com a tabela abaixo.
IMC em adultos Condição:
Abaixo de 18,5 Abaixo do peso
Entre 18,5 e 25 Peso normal
Entre 25 e 30 Acima do peso
Acima de 30 obeso
*/
import java.util.Scanner;
public class Exe10{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        double peso = 0, altura = 0, imc = 0;

        System.out.print("Informe o peso em quilos: ");
        peso = teclado.nextDouble();
        System.out.print("Informe a altura em metros:");
        altura = teclado.nextDouble();
        
        imc = peso / (altura * 2);;

        if(imc < 18.5){
            System.out.print("Abaixo do peso.");
        }
        else if(imc >= 18.5 && imc < 25){
            System.out.print("Peso normal.");
        }
        else if(imc >= 25 && imc < 30){
            System.out.print("Acima do peso");
        }
        else{
            System.out.print("Obeso");
        }
        teclado.close();
    }
}