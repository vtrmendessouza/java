import java.util.Scanner;
public class Exe05{
	public static void main(String[] args){
        /*
        Calculo de Frete de Entrega:
        Crie um programa que calcule o custo de frete com base no peso de um pacote.
        Se o peso for até 5 kg, o custo é de R$ 20,00.
        Se o peso for maior que 5 kg o custo é de R$ 50,00.
        Obtenha o valor do produto e o peso.
        Exiba o valor final que é a soma do valor do frete mais o valor do produto.
        */
        Scanner teclado = new Scanner(System.in);
        float peso = 0, custoFrete = 0, valorProduto = 0, valorFinal = 0;
        
        System.out.print("informe o peso: ");
        peso = teclado.nextInt();

        System.out.print("informe o valor: ");
        valorProduto = teclado.nextInt();

        if(peso <= 5){
            custoFrete = 20;
            valorFinal = custoFrete + valorProduto;
            System.out.printf("valor final: %.2f", valorFinal);
        }
        else{
            custoFrete = 50;
            valorFinal = custoFrete + valorProduto;
            System.out.printf("valor final: %.2f", valorFinal);
        }
        teclado.close();
    }
}