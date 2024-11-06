/*
Exercício 5
Desafio: Reescreva este código adicionando:
Método que retorna um int chamado lerInt. 
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que retorna um float chamado lerFloat. 
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Com base nos exercícios anteriores, escreva um método que retone o cálculo da conversão para cada um das unidades de medias: 
metros, quilometros, milhas, jardas, polegadas e pés. 
*/
import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercicio05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        double centimetros = lerDouble(teclado, "Digite a medida em centímetros: ");
        int escolha = obterEscolha(teclado);
        conversao(teclado, escolha, centimetros);
        teclado.close();
    }
    static int lerInt(Scanner teclado, String mensagem){
        int valorInt = 0;
        boolean flag = true;
        do{
            try {
                System.out.println(mensagem);
                valorInt = teclado.nextInt();
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        return valorInt;
    }
    static double lerDouble(Scanner teclado, String mensagem){
        double valorDouble = 0;
        boolean flag = true;
        do{
            try {
                System.out.println(mensagem);
                valorDouble = teclado.nextDouble();
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        return valorDouble;
    }
    static int obterEscolha(Scanner teclado){
        System.out.println("Para qual unidade deseja converter?");
        System.out.println("1 - Metros");
        System.out.println("2 - Quilômetros");
        System.out.println("3 - Milhas");
        System.out.println("4 - Jardas");
        System.out.println("5 - Pés");
        System.out.println("6 - Polegadas");
        int escolha = lerInt(teclado, "Digite o código desejado: ");
        return escolha;
    }
    static void conversao(Scanner teclado, int escolha, double centimetros){
        switch (escolha) {
            case 1:
                double metros = centimetros / 100;
                System.out.println(centimetros + " centímetros é igual a " + metros + " metros.");
                break;
            case 2:
                double quilometros = centimetros / 100000;
                System.out.println(centimetros + " centímetros é igual a " + quilometros + " quilômetros.");
                break;
            case 3:
// 1 milha = 160934 centímetros
                double milhas = centimetros / 160934;
                System.out.println(centimetros + " centímetros é igual a " + milhas + " milhas.");
                break;
            case 4:
// 1 jarda = 91.44 centímetros
                double jardas = centimetros / 91.44;
                System.out.println(centimetros + " centímetros é igual a " + jardas + " jardas.");
                break;
            case 5:
// 1 pé = 30.48 centímetros
                double pes = centimetros / 30.48;
                System.out.println(centimetros + " centímetros é igual a " + pes + " pés.");
                break;
            case 6:
// 1 polegada = 2.54 centímetros
                double polegadas = centimetros / 2.54;
                System.out.println(centimetros + " centímetros é igual a " + polegadas + " polegadas.");
                break;
            default:
                System.out.println("Escolha inválida! Por favor, selecione de 1 a 6.");
                break;
        }
    }
}
