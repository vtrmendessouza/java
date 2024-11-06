import java.util.Scanner;
public class Exe03{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
            
        double quantidadeCavalo = 0, valorFerradura = 0, quantidadeFerradura = 0, valorTotal;
            
        System.out.print("Informe a quantidade de cavalos: ");
        quantidadeCavalo = teclado.nextDouble();
        System.out.print("Informe o valor da ferradura em reais: ");
        valorFerradura = teclado.nextDouble();
            
        quantidadeFerradura = quantidadeCavalo * 4;
        valorTotal = quantidadeFerradura * valorFerradura;
            
        System.out.printf("Quantidade de ferraduras necessárias: %.2f\n", quantidadeFerradura);
        System.out.printf("Valor necessário para a compra: %.2f\n", valorTotal);
        teclado.close();
    }
}