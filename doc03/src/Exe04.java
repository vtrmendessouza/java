/*
Exercício 04: 
Um empresa resolveu dar um aumento de salário aos seus colaboradores 
e lhe contraram para desenvolver o programa que calculará os reajustes. 
Faça um programa que recebe o salário de um colaborador e 
faça o reajuste segundo o seguinte critério, baseado no salário atual:
salários até R$ 280,00 (incluindo) : aumento de 20%
salários entre R$ 280,00 e R$ 700,00 : aumento de 15%
salários entre R$ 700,00 e R$ 1500,00 : aumento de 10%
salários de R$ 1500,00 em diante : aumento de 5%
Após o aumento ser realizado, informe na tela: 
- o salário antes do reajuste;
- o percentual de aumento aplicado;
- o valor do aumento;
- o novo salário, após o aumento.
*/
import java.util.Scanner;
public class Exe04{
	public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        float salarioInicial = 0, percentual = 0, aumento = 0, salarioFinal = 0;

        System.out.print("Informe o valor atual: ");
        salarioInicial = teclado.nextFloat();
        teclado.nextLine();

        if(salarioInicial <= 280){
            percentual = 20;
            aumento = salarioInicial * 0.2f;
            salarioFinal = salarioInicial + aumento;
        }
        else if(salarioInicial > 280 && salarioInicial <= 700){
            percentual = 15;
            aumento = salarioInicial * 0.15f;
            salarioFinal = salarioInicial + aumento;
        }
        else if(salarioInicial > 700 && salarioInicial <= 1500){
            percentual = 10;
            aumento = salarioInicial * 0.1f;
            salarioFinal = salarioInicial + aumento;
        }
        else if(salarioInicial > 1500){
            percentual = 5;
            aumento = salarioInicial * 0.05f;
            salarioFinal = salarioInicial + aumento;
        }
        System.out.printf("Salário antes do reajuste: R$%.2f\n", salarioInicial);
        System.out.printf("Percentual de aumento aplicado: %.0f%%\n", percentual);
        System.out.printf("Valor do aumento: R$%.2f\n", aumento);
        System.out.printf("Salário após reajuste: R$%.2f\n", salarioFinal);
        teclado.close();
    }
}