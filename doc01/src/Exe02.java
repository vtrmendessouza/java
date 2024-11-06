import java.util.Scanner;
public class Exe02{
	public static void main(String[] args){
        /*
        Calculo de Desconto em Compra:
        Implemente um programa que calcule o desconto em uma compra com base no valor total.
        Se o valor total for maior que R$ 100,00 reais, aplique um desconto de 10%.
        Solicite o valor da compra e informe o valor final com o desconto aplicado se for o caso.
        */
        Scanner teclado = new Scanner(System.in);
        double valor = 0, valorDesconto = 0.9;
            
        System.out.print("informe o valor: ");
        valor = teclado.nextDouble();

        if(valor > 100){
            System.out.printf("total: %.2f\n", valor * valorDesconto);
        }
        else{
            System.out.printf("total: %.2f\n", valor);
        }
        teclado.close();
    }
}