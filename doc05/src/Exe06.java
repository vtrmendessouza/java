/*
Primeiro Código com Funções e Procedimentos
Exercício dos morangos e maças escrito utilizando funções e procedimentos, 
que em java chamamos de métodos.
*/
import java.util.Scanner;
public class Exe06 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        float qtdeMaca;
        float qtdeMorango;
        float valorTotalMaca, valorTotalMorango;

        qtdeMaca = obterFloat(teclado, "Digite quantos KG de Macas foram comprados: ");
        qtdeMorango = obterFloat(teclado, "Digite quantos KG de Morangos foram comprados: ");
        valorTotalMaca = calcularValorMaca(qtdeMaca);
        valorTotalMorango = calcularValorMorango(qtdeMorango);

        mostrarValorTotal(valorTotalMaca, valorTotalMorango);
        teclado.close();
    }
//Funcao ou metodo que retorna valor
    static float calcularValorMorango(float qtdeMorango){
        float valorTotalMorango;
// estrutura de decisao
        if (qtdeMorango > 5) {
// e executado quando qtdeMorange é > 5
            valorTotalMorango = qtdeMorango * 2.2f;
        } else {
// e executado quando qtdeMorange nao é > 5
            valorTotalMorango = qtdeMorango * 2.5f;
        }
        return valorTotalMorango;
    }
//Funcao ou metodo que retorna valor  
    static float calcularValorMaca(float qtdeMaca) {
        float valorTotalMaca;

        if (qtdeMaca <= 5) {
// verdade
            valorTotalMaca = qtdeMaca * 1.8f;
        } else {
// falso
            valorTotalMaca = qtdeMaca * 1.5f;
        }
       return valorTotalMaca;
    }
//Funcao ou metodo que retorna valor
    static float obterFloat(Scanner teclado, String mensagem) {

        float valor;
        System.out.print(mensagem);
        valor = teclado.nextFloat();
        return valor;
    }
//Procedimento ou metodo
    static void mostrarValorTotal(float valorTotalMaca, float valorTotalMorango){

        float totalCompra;
        totalCompra = valorTotalMaca + valorTotalMorango;
        System.out.println("O valor total da compra e R$ " + totalCompra);
    }
}
