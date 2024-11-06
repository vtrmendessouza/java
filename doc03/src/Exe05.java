/*
Exercício 05: 
Faça um programa para o cálculo de uma folha de pagamento, sabendo que os descontos são 
do Imposto de Renda, que depende do salário bruto (conforme tabela abaixo) 
e 3% para o Sindicato e que o FGTS corresponde a 11% do Salário Bruto, mas não é descontado (é a empresa que deposita). 
O Salário Líquido corresponde ao Salário Bruto menos os descontos. 
O programa deverá pedir ao usuário o valor da sua hora e a quantidade de horas trabalhadas no mês.
Desconto do IR:
Salário Bruto até 900 (inclusive) - isento
Salário Bruto até 1500 (inclusive) - desconto de 5%
Salário Bruto até 2500 (inclusive) - desconto de 10%
Salário Bruto acima de 2500 - desconto de 20% 
Imprima na tela as informações, dispostas conforme o exemplo abaixo. Exemplo:
QTDE de Horas Trabalhadas: 5
Valor da hora trabalhada R$: 220.00
Salário Bruto: (5 * 220)        : R$ 1100,00
(-) IR (5%)                     : R$   55,00  
(-) INSS ( 10%)                 : R$  110,00
FGTS (11%)                      : R$  121,00
Total de descontos              : R$  165,00
Salário Liquido                 : R$  935,00
*/
import java.util.Scanner;
public class Exe05{
	  public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        float valorHora = 0, quantidadeHora = 0, ir = 0.05f, inss = 0.1f, fgts = 0.11f;
        float salarioBruto = 0, descontoTotal = 0, salarioLiquido = 0;

        System.out.print("Informe o valor da hora: ");
        valorHora = teclado.nextFloat();
        teclado.nextLine();
        System.out.print("Informe a quantidade de horas: ");
        quantidadeHora = teclado.nextFloat();
        teclado.nextLine();        

        salarioBruto = valorHora * quantidadeHora;
        descontoTotal = salarioBruto * (ir + inss);
        salarioLiquido = salarioBruto - descontoTotal;

        System.out.printf("Salário bruto: %.2f\n", salarioBruto);
        System.out.printf("IR: %.2f\n", salarioBruto * ir);
        System.out.printf("INSS: %.2f\n", salarioBruto * inss);
        System.out.printf("FGTS: %.2f\n", salarioBruto * fgts);
        System.out.printf("Total de descontos: %.2f\n", descontoTotal);
        System.out.printf("Salário líquido: %.2f\n", salarioLiquido);

        teclado.close();
        System.exit(0);
    }
}