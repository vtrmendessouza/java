import java.util.Scanner;
public class Exe04{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
            
        double salarioInicial = 0, salarioReajustado = 0, valorInss = 0, valorFgts = 0, totalDesconto = 0, salarioFinal = 0;
            
        System.out.print("Informe o valor do salário em reais: ");
        salarioInicial = teclado.nextDouble();

        salarioReajustado = salarioInicial * 1.15;
        valorInss = salarioReajustado * 0.11;
        valorFgts = salarioReajustado * 0.08;
        totalDesconto = valorInss + valorFgts;
        salarioFinal = salarioReajustado - valorInss - valorFgts;
            
        System.out.printf("Salário inicial: %.2f\n", salarioInicial);
        System.out.printf("Salário reajustado: %.2f\n", salarioReajustado);
        System.out.printf("Desconto 11%% INSS: %.2f\n", valorInss);
        System.out.printf("Desconto 8%% FGTS: %.2f\n", valorFgts);
        System.out.printf("Total de descontos INSS + FGTS: %.2f\n", totalDesconto);
        System.out.printf("Salário final: %.2f\n", salarioFinal);
        teclado.close();
    }
}
