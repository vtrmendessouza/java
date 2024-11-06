/*
Elabore um algoritmo que calcule o que deve ser pago por um produto, 
considerando o preço normal de etiqueta e a escolha da condição de pagamento. 
Utilize os códigos da tabela a seguir para ler qual acondição de pagamento escolhida 
e efetuar o cálculo adequado. Código Condição de pagamento:
1 À vista em dinheiro ou cheque, recebe 10% de desconto
2 À vista no cartão de crédito, recebe 15% de desconto
3 Em duas vezes, preço normal de etiqueta sem juros
4 Em duas vezes, preço normal de etiqueta mais juros de 10%
*/
import java.util.Scanner;
public class Exe11{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float precoEtiqueta = 0, desconto = 0, precoFinal;
        int pagamento = 0;

        System.out.print("Informe o preço de etiqueta: ");
        precoEtiqueta = teclado.nextFloat();
        
        do{
            System.out.print("Escolha a forma de pagamento conforme a tabela:\n");
            System.out.print("1 - À vista em dinheiro ou cheque, recebe 10% de desconto.\n");
            System.out.print("2 - À vista no cartão de crédito, recebe 15% de desconto.\n");
            System.out.print("3 - Em duas vezes, preço normal de etiqueta sem juros.\n");
            System.out.print("4 - Em duas vezes, preço normal de etiqueta mais juros de 10%:\n");
            System.out.print("Informe a opção desejada: ");
            pagamento = teclado.nextInt();

            if(pagamento == 1){
                desconto = 0.9f;
            }
            else if(pagamento == 2){
                desconto = 0.85f;
            }
            else if(pagamento == 3){
                desconto = 1;
            }
            else if(pagamento == 4){
                desconto = 1.1f;
            }
            else{
                System.out.println("Opção inválida.");
            }
        }
        while(pagamento < 1 || pagamento > 4);
        precoFinal = precoEtiqueta * desconto;

        System.out.printf("Valor a ser pago: R$ %.2f", precoFinal);
        teclado.close();
    }
}