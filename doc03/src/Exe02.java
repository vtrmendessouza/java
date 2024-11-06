/*
Exercício 02: 
Um posto está vendendo combustíveis com a seguinte tabela de descontos: 
Álcool: até 20 litros, desconto de 3% por litro, 
acima de 20 litros, desconto de 5% por litro 
Gasolina: até 20 litros, desconto de 4% por litro, 
acima de 20 litros, desconto de 6% por litro 
Escreva um algoritmo que leia o número de litros vendidos, 
o tipo de combustível como um número inteiro 
(codificado da seguinte forma: 1 - álcool, 2 - gasolina), 
calcule e imprima o valor a ser pago pelo cliente sabendo-se que 
o preço do litro da gasolina é R$ 5,50 e o preço do litro do álcool é R$ 3,90.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Exe02{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int tipo = 0;
        float quantidade = 0, desconto = 0, precoFinal = 0, precoAlcool = 3.9f, precoGasolina = 5.5f;
        
        do{
            System.out.print("Digite 1 para álcool ou 2 para gasolina: ");
            try{
            tipo = teclado.nextInt();
                if(tipo != 1 && tipo != 2){
                System.out.print("Você não escolheu uma opção válida.\n");       
                }
            }
            catch(InputMismatchException erroFracionario){
            System.out.print("Você não digitou um número inteiro.\n");
            teclado.nextLine();
            }
        }
        while(tipo != 1 && tipo != 2);
        
        do{
            System.out.print("Digite a quantidade: ");
            quantidade = teclado.nextFloat();
            if(quantidade < 0){
                System.out.print("Você não digitou um número positivo.\n");
            }
        }
            while (quantidade < 0);
            
        if(tipo == 1 && quantidade <= 20){
            desconto = 0.97f;
            precoFinal = precoAlcool * quantidade * desconto;
        }
        else if(tipo == 1 && quantidade > 20){
            desconto = 0.95f;
            precoFinal = precoAlcool * quantidade * desconto;
        }
        else if(tipo == 2 && quantidade <= 20){
            desconto = 0.96f;
            precoFinal = precoGasolina * quantidade * desconto;
        }
        else if(tipo == 2 && quantidade > 20){
            desconto = 0.94f;
            precoFinal = precoGasolina * quantidade * desconto;
        }
        else{
            System.out.print("Dados incorretos.\n");
        }
        System.out.printf("Valor com desconto: %.2f", precoFinal);
        teclado.close();
    }
}