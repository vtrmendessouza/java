/*
Exercício 4
Desafio: Reescreva este código adicionando:
Método que retorna um int chamado lerInt. 
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que retorna um float chamado lerFloat. 
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
O teclado serautilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que retorna um float chamado calcularAreaCirculo. 
Este método receberá um parâmetro que será o teclado. 
O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do círculo e retornar um float que será a área calculada.
Método que retorna um float chamado calcularAreaQuadrado. 
Este método receberá um parâmetro que será o teclado. 
O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do quadrado e retornar um float que será a área calculada.
Método que retorna um float chamado calcularAreaTriangulo. 
Este método receberá um parâmetro que será o teclado. 
O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do triângulo e retornar um float que será a área calculada.
Método que retorna um float chamado calcularAreaRetangulo. 
Este método receberá um parâmetro que será o teclado. 
O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do retângulo e retornar um float que será a área calculada.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Exercicio04 {
    public static void main(String[] args) throws Exception{
        Scanner teclado = new Scanner(System.in);
        int encerrar = 0;
        do{
            if(encerrar == 0){
                System.out.println("Bem vindo!");
            }
            else{
                System.out.println("Bem vindo novamente!");
            }
            int escolha = obterEscolha(teclado);
            calcularAreas(teclado, escolha);
            encerrar = opcaoFinal(teclado);
        }
        while(encerrar == 1);
        System.out.println("Até breve!");
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
        System.out.println("Escolha a figura: ");
        System.out.println("1: Quadrado ");
        System.out.println("2: Retângulo ");
        System.out.println("3: Círculo ");
        System.out.println("4: Triângulo ");
        int escolha = lerInt(teclado, "Digite o código desejado: ");
        return escolha;
    }
    static double calcularAreaQuadrado(Scanner teclado){
        double lado = lerDouble(teclado, "Digite o lado do quadrado: ");
        return (lado * lado);
    }
    static void calcularAreaRetangulo(Scanner teclado){
        double largura = lerDouble(teclado, "Digite a largura do retângulo: ");
        double alturaRetangulo = lerDouble(teclado, "Digite a altura do retângulo: ");
        System.out.println("A área do retângulo é: " + (largura * alturaRetangulo));
    }
    static void calcularAreaCirculo(Scanner teclado){
        double raio = lerDouble(teclado, "Digite o raio do círculo: ");
        System.out.println("A área do círculo é: " + (Math.PI * Math.pow(raio, 2)));
    }
    static void calcularAreaTriangulo(Scanner teclado){
        double base = lerDouble(teclado, "Digite a base do triângulo: ");
        double alturaTriangulo = lerDouble(teclado, "Digite a altura do triângulo: ");
        System.out.println("A área do triângulo é: " + ((base * alturaTriangulo) / 2));
    }
    static void calcularAreas(Scanner teclado, int escolha){
        switch (escolha) {
            case 1:
                System.out.println("A área do quadrado é: " + calcularAreaQuadrado(teclado));
                break;

            case 2:
                calcularAreaRetangulo(teclado);
                break;
                
            case 3:
                calcularAreaCirculo(teclado);
                break;
                
            case 4:
                calcularAreaTriangulo(teclado);
                break;
                
            /*default:
                System.out.println("Escolha inválida!");
                break;*/
        }
    }
    static int opcaoFinal(Scanner teclado){
        int encerrar = 0;
        boolean flag = true;
        do{
            try {
                encerrar = lerInt(teclado, "Digite 1 para repetir ou 0 para encerrar: ");
                if(encerrar == 0 || encerrar == 1){
                    flag = false;
                }
                else{
                    System.out.println("Valor incorreto.");
                }
            }
            catch(InputMismatchException variavException){
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        return encerrar;
    }
}